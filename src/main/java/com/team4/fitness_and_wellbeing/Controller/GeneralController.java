package com.team4.fitness_and_wellbeing.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class GeneralController {

    @RequestMapping(path = "/public/userLogin")
    public String userLogin(String name){
        return "UserLogin";
    }

    @RequestMapping(path = "/public/userComment")
    public String userComment(String name){
        return "UserComment";
    }

}
