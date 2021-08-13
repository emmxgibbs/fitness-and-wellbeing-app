package com.team4.fitness_and_wellbeing.Comment;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
@Mapper
public interface CommentMapper {
    @Select("SELECT * FROM comment")

    List<Comment> findAll();
}
