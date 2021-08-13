package com.team4.fitness_and_wellbeing.Controller;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import java.security.Principal;
import java.util.List;

@Controller
public class navController {
    @RequestMapping(path = "/")
    ModelAndView navHomePage(){
        return new ModelAndView("forward:/html/home.html");
    }

//    @RequestMapping(path = "/public/console")
//    //check if user logged
//    ModelAndView navLogin(Principal principal){
//        //check if logged in
//        //if not then log user in
//        try {
//            System.out.println(principal.getName());
//        }catch (Exception e){
//            System.out.println("error attempting to get user name: "+e.toString());
//        }
//        return new ModelAndView("redirect:/html/login.html");
//    }
    @RequestMapping(path = "/console")
    public ModelAndView navConsole() {
        //        UserDetails userDetails = (UserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        //        String username = userDetails.getUsername();
        //        UserDto currentUser = this.userDetailsService.getCurrentUserProfileInfo(username);

        //        switch(currentUser.getUser_type()){
        //            case "trainer":
        return new ModelAndView("forward:/html/console.html");
        //        }
    }

    @RequestMapping(value = {"/home", "/"})
    ModelAndView navHome() {
        return new ModelAndView("forward:/html/home.html");
    }

    @RequestMapping(value = {"/login"})
    ModelAndView navLogin() {
        return new ModelAndView("forward:/html/login.html");
    }

    @RequestMapping(path = "/hello")
    public String hello(){
        return "hello world";
    }

//    @RequestMapping(path = "/public/userRegister")
//    ModelAndView navRegister(){
//        return new ModelAndView("forward:/html/UserRegister.html");
//    }
//
//    @RequestMapping(path = "/public/home")
//    ModelAndView navHome(){
//        return new ModelAndView("forward:/html/home.html");
//    }


    @RequestMapping(path = "/uploadImgAjax")
    ModelAndView navuploadimgAjax(){
        return new ModelAndView("forward:/html/ajaxIndex.html");
    }
    @RequestMapping(path = "/uploadImgDuo")
    ModelAndView navuploadImgDuo(){
        return new ModelAndView("forward:/html/multipleIndex.html");
    }
    @RequestMapping(path = "/doExercise")
    ModelAndView navDoExercise(){
        return new ModelAndView("forward:/html/ExercisePage.html");
    }

    @RequestMapping(path = "/goExercise")
    ModelAndView navDoingExercise(){
        return new ModelAndView("forward:/html/Exercise.html");
    }
    @RequestMapping(path = "/comment")
    ModelAndView navComment(){
        return new ModelAndView("forward:/html/consoleClient.html");
    }

    @RequestMapping(path = "/countdown")
    ModelAndView navCountdown(){
        return new ModelAndView("forward:/html/CountDown.html");
    }

    @RequestMapping(path = "/completeDetails")
    ModelAndView navAddDetails(){
        return new ModelAndView("forward:/html/completeDetails.html");
    }



    @RequestMapping(path = "/viewComment")
    public String navCoooo(){
        return "consoleTrainer_2";
    }
}
