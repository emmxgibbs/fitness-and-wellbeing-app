package com.team4.fitness_and_wellbeing.service;


import com.team4.fitness_and_wellbeing.model.Details;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface DetailsRepository extends CrudRepository<Details, Integer> {

    List<Details> findAllById (String id);


}
