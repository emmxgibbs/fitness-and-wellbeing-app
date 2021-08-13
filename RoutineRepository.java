package com.team4.fitness_and_wellbeing.Login;

import com.team4.fitness_and_wellbeing.Dao.RoutineDao;
import org.apache.ibatis.annotations.Param;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface RoutineRepository extends CrudRepository<RoutineDao, Integer> {

    @Query(value = "SELECT * FROM routines WHERE routines.trainer_id = :trainerId", nativeQuery = true)
    public List<RoutineDao> getRoutinesForTrainer(@Param("trainerId") long trainerId);


}
