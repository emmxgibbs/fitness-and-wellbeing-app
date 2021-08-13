package com.team4.fitness_and_wellbeing.Controller;

import com.team4.fitness_and_wellbeing.Comment.Comment;

import com.team4.fitness_and_wellbeing.Comment.CommentMapper;
import com.team4.fitness_and_wellbeing.Comment.CommentRepository;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import java.util.List;

@Controller
public class CommentController {

    private static final Logger log = LoggerFactory.getLogger(UserController.class);
    @Autowired
    private CommentRepository commentRepository;
    private JdbcTemplate jdbcTemplate;

    @GetMapping(path = "/addComment")
    ModelAndView addNewComment(@RequestParam String content,
                               Comment comment) {
        comment.setContent(content);
        commentRepository.save(comment);
        log.info(comment.toString() + "save to the repo");
        return new ModelAndView("forward:/html/consoleClient.html");
    }



    @Autowired
    CommentMapper commentMapper;
    @RequestMapping("/showcomments")
    public String listComment(Model model){
        List<Comment> comments = commentMapper.findAll();
        model.addAttribute("comments",comments);
        return "comment";
    }




}