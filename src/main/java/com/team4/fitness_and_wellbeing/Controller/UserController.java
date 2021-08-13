package com.team4.fitness_and_wellbeing.Controller;

import com.team4.fitness_and_wellbeing.Login.UserRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class UserController {



//    private static final Logger log = LoggerFactory.getLogger(UserController.class);
//    @Autowired
//    private UserRepository userRepository;
//
//
//    @GetMapping(path = "/public/add")
//    public String addNewUser(@RequestParam String name,
//                                           @RequestParam String email,
//                                           @RequestParam String password,
//                                           @RequestParam String usertype,
//                                           User user){
//        user.setName(name);
//        user.setEmail(email);
//        user.setPassword(password);
//        user.setUsertype(usertype);
//
//
//        userRepository.save(user);
//        log.info(user.toString()+" save to the database");
//
//        return "forward:/html/console.html";

//    }





//    @GetMapping(path = "/public/userlogin")
//    public String login(@RequestParam String email,
//                        @RequestParam String password,
//                        Model model){
////        List<User> users = userRepository.findByEmail(email);
//        User user = userRepository.findByEmail(email);
//        if (user == null){
//            log.warn("attempting to log in with the non-existed account");
//            return "this user not exist";
//
//        }else {
////            User user = user.get(0);
//            if (user.getPassword().equals(password)){
//                model.addAttribute("name",user.getName());
//                System.out.println(model.getAttribute("name"));
//                log.warn(user.toString()+"login successful");
//
//            }else {
//                model.addAttribute("name","logging failed");
//                log.warn(user.toString()+"failed login");
//            }
//            return "forward:/html/console.html";
//        }
//    }
//
//
//
//
//
//
//
//    @GetMapping(path = "/public/all")
//    public @ResponseBody Iterable<User> getAllUsers(){
//        return userRepository.findAll();
//    }
}
