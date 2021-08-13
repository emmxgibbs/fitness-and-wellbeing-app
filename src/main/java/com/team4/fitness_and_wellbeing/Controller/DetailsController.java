package com.team4.fitness_and_wellbeing.Controller;

import com.team4.fitness_and_wellbeing.mapper.DetailsMapper;
import com.team4.fitness_and_wellbeing.model.Details;
import com.team4.fitness_and_wellbeing.service.DetailsRepository;
import com.team4.fitness_and_wellbeing.service.DetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

@Controller
public class DetailsController {



    @Autowired
    private DetailsRepository detailsRepository;
    private JdbcTemplate jdbcTemplate;



    @GetMapping(path = "/addDetails")
    ModelAndView addNewDetails(
            @RequestParam String sex,
                               String height,
                               String weight,
                               String level,
                               String speciality,
                               String qualification,
                               String organisation,
                               Details details
                              ) {
        details.setSex(sex);
        details.setHeight(height+"cm");
        details.setWeight(weight+"kg");
        details.setLevel(level);
        details.setSpeciality(speciality);
        details.setQualification(qualification);
        details.setOrganisation(organisation);
        detailsRepository.save(details);

        return new ModelAndView("forward:/html/consoleClient.html");
    }

    @Resource
    private DetailsService detailsService;
    @RequestMapping(path = "/updateInfo",method = RequestMethod.POST)
    public void updateInfo(@RequestParam(value = "sex") String sex,
                           @RequestParam(value = "height") String height,
                           @RequestParam(value = "weight") String weight,
                           @RequestParam(value = "level") String level,
                           @RequestParam(value = "speciality") String speciality,
                           @RequestParam(value = "qualification") String qualification,
                           @RequestParam(value = "organisation") String organisation,
                           HttpServletRequest request,
                           HttpServletResponse response){
        HttpSession session = null;
        response.reset();
        PrintWriter out = null;
        try{
            response.reset();
            out = response.getWriter();
            session = request.getSession();
            String id = ((Details)session.getAttribute("Details")).getId();
            boolean ch = detailsService.updateService(id,sex,height,weight,level,speciality,qualification,organisation);
            if (ch) out.print("success");
            else out.print("error");
            out.flush();
        }catch (IOException e){
            e.printStackTrace();
        }finally {
            out.close();
        }
    }



    // request visit personal details
    @RequestMapping("/DetailsInfo")
    public String DetailsInfo(HttpServletRequest request){
        updatePageInfo(request);
        return "updateDetails";
    }


    // request page refresh
    public void updatePageInfo(HttpServletRequest request){
        try{
            HttpSession session = request.getSession();
            String id = ((Details)session.getAttribute("details")).getId();
            Details details = detailsService.getDetails(id);
            session.setAttribute("details",details);
        }catch (Exception e){
            e.printStackTrace();
        }finally {}
    }



    @Autowired
    DetailsMapper detailsMapper;
    @RequestMapping("/showDetails")
    public String listDetails(Model model){
        List<Details> details = detailsMapper.findAll();
        model.addAttribute("details",details);
        return "showdetails";
    }



    @RequestMapping(value = "/update",method = RequestMethod.PUT)
    public boolean updateUser(Details details){
        return detailsService.update(details);
    }

}
