package com.project.prepearindExam.controller;

import com.project.prepearindExam.models.Question;
import com.project.prepearindExam.service.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/exam/java")
public class QuestionController {
    private final QuestionService questionService;

    @Autowired
    public QuestionController(QuestionService questionService){
        this.questionService = questionService;
    }

    @GetMapping("/add")
    public Question add(@RequestParam("question") String question,
                        @RequestParam("answer") String answer){
        return questionService.addQuestion(question, answer);
    }

    @DeleteMapping("/remove")
    public Question remove(@RequestParam("question") String question,
                        @RequestParam("answer") String answer){
        return questionService.removeQuestion(question, answer);
    }

    @GetMapping()
    public List<Question> allQuestion(){
        return questionService.getQuestions();
    }



}
