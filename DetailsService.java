package com.team4.fitness_and_wellbeing.service;

import com.team4.fitness_and_wellbeing.model.Details;

import java.util.List;

public interface DetailsService {

    public Details getDetails(String id);
    public boolean updateService(String id,
                                 String sex,
                                 String height,
                                 String weight,
                                 String level,
                                 String speciality,
                                 String qualification,
                                 String organisation
                                 );

    boolean update(Details details);
}
