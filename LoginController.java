package com.team4.fitness_and_wellbeing.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class LoginController {

    @RequestMapping(path = "/submitLogin")
    public String login(String name){
        return "home";
    }

}
