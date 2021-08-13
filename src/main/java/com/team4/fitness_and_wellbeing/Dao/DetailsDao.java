package com.team4.fitness_and_wellbeing.Dao;

import com.team4.fitness_and_wellbeing.model.Details;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Update;

@Mapper
public interface DetailsDao {


    public Details selectById(String id);



    public void updateById(@Param("sex") String sex,
                           @Param("weight") String weight,
                           @Param("height") String height,
                           @Param("speciality") String speciality,
                           @Param("qualification") String qualification,
                           @Param("organisation") String organisation,
                           @Param("id") String id);


    @Update("UPDATE details SET sex=#{sex},height=#{height},weight=#{weight},level=#{level},speciality=#{speciality},qualification=#{qualification},organisation=#{organisation} WHERE id=#{id}")
    boolean update(Details details);


}
