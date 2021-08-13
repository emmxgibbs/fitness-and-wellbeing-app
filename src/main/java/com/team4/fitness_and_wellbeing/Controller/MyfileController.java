package com.team4.fitness_and_wellbeing.Controller;



import com.team4.fitness_and_wellbeing.mapper.VideoMapper;
import com.team4.fitness_and_wellbeing.model.Video;
import com.team4.fitness_and_wellbeing.service.VideoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Controller
public class MyfileController {

    @Autowired
    VideoService videoService;

//    @Resource
//    private VideoMapper videoMapper;
    String url;

    @RequestMapping(value = "/uploadFile", produces = "application/json;charset=UTF-8")
    @ResponseBody
    public String uploadFile(@RequestParam("fileName")MultipartFile file,
                             @RequestParam("description") String description,
                             @RequestParam("title") String title){
        if (file.isEmpty()){
            return "The upload file cannot be empty! Please return!";
        }

        String fileName = file.getOriginalFilename();

        String path = "C:/fileUpload/" + fileName;
//        fileName = new SimpleDateFormat("yyyyMMddHHmmss").format(new Date()) + "-" + fileName;

        File dest = new File(path);
        if (dest.exists()){
            return "The file is existed, Please return!";
        }

        if (!dest.getParentFile().exists()){
            dest.getParentFile().mkdir();
        }

        try{
            file.transferTo(dest);
            url = "http://localhost:8080/images/" + fileName;
            videoService.insertUrl(fileName, path, url, description, title);
        }catch (IOException e){
            return "Fail to upload, Please return!";
        }
        return "Successfully upload!";
    }

   // Search
    @RequestMapping("/search")
    public String turnToList(Model model){
        System.out.println("Search videos" + "\n");
        List<Video> videos = videoService.selectVideo();
        System.out.println("Number of videos" + videos.size());
        model.addAttribute("Videos", videos);
        return "view_exercise";
    }

    //Delete
    @RequestMapping("/deleteFile")
    public String deleteFile(@RequestParam("id") Long id){
        videoService.removeById(id);
        return "redirect:/search";
    }

    //Update
//    @RequestMapping("/updateFile")
//    public String updateFile(Video video){
//        boolean flag = videoMapper.update(video) > 0;
//        return "redirect:/search";
//    }

    //Search file for update
//    @RequestMapping("/findFile")
//    public String findFile(Long id, Model model){
//        Video video = videoMapper.getFile(id);
//        model.addAttribute("Videos",video);
//        return "edit_exercise";
//    }

}
