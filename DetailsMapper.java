package com.team4.fitness_and_wellbeing.mapper;


import com.team4.fitness_and_wellbeing.model.Details;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Mapper
public interface DetailsMapper {
    @Select("SELECT * FROM details")
    List<Details> findAll();


    @Update("UPDATE details SET sex=#{sex},height=#{height},weight=#{weight},level=#{level},speciality=#{speciality},qualification=#{qualification},organisation=#{organisation} WHERE id=#{id}")
    boolean updateById(Details details);


}
