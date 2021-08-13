package com.team4.fitness_and_wellbeing.Login;

import com.team4.fitness_and_wellbeing.Dao.RoutineDao;
import com.team4.fitness_and_wellbeing.Dao.VideosRoutinesDao;
import org.springframework.data.repository.CrudRepository;

public interface VideosRoutinesRepository extends CrudRepository<VideosRoutinesDao, Integer> {
}
