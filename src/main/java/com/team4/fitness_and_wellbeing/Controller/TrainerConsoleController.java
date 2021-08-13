package com.team4.fitness_and_wellbeing.Controller;


import com.team4.fitness_and_wellbeing.model.Client;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;

@RestController
public class TrainerConsoleController {
    @RequestMapping(path = "/getClientList")
    public ArrayList<Client> getClients(){
        return Client.clientArrayList;
    }
}