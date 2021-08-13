package com.team4.fitness_and_wellbeing.Controller;

import com.team4.fitness_and_wellbeing.model.UserDto;
import com.team4.fitness_and_wellbeing.service.MyUserDetailsService;
import com.team4.fitness_and_wellbeing.utils.JwtUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;

@RestController
public class ConsoleController {
    @Autowired
    private MyUserDetailsService userDetailsService;

    @Autowired
    private JwtUtil jwtUtil;

    @RequestMapping(path = "/getUserInfo", method = RequestMethod.GET)
    ResponseEntity<?> getUserInfo(){
        try {
            UserDetails userDetails = (UserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
            String username = userDetails.getUsername();
            UserDto currentUser = this.userDetailsService.getCurrentUserProfileInfo(username);
            return ResponseEntity.ok(currentUser);
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
        return ResponseEntity.ok("/login");
    }

    @RequestMapping(value = "/verifyUser", method = RequestMethod.GET)
    public ModelAndView verifyUser(HttpServletRequest request){
        String requestHeader = request.getHeader("Authorization");

        String username = null;
        String jwt;

        if (requestHeader!=null && requestHeader.startsWith("Bearer ")){
            jwt = requestHeader.substring(7);
            username = jwtUtil.extractUsername(jwt);
        }

        try{
            UserDto currentUser = this.userDetailsService.getCurrentUserProfileInfo(username);
            if(currentUser.getUser_type().equals("trainer")){
                return new ModelAndView("forward:/html/consoleTrainer.html");
            }else{
                return new ModelAndView("forward:/html/consoleClient.html");
            }
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
        return new ModelAndView("error");
    }
}
