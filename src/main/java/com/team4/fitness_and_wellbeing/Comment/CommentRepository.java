package com.team4.fitness_and_wellbeing.Comment;

import com.team4.fitness_and_wellbeing.model.Details;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface CommentRepository extends CrudRepository<Comment, Integer> {

    List<Comment> findAllByContent (String content);


}
