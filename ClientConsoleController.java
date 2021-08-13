package com.team4.fitness_and_wellbeing.Controller;

import com.team4.fitness_and_wellbeing.model.Workouts;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;

@RestController
public class ClientConsoleController {

    @RequestMapping(path = "/getRoutines")
    public ArrayList<Workouts> getClientRoutines(){
        return Workouts.WorkoutArrayList;
    }


}
