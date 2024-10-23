package com.project.prepearindExam.controller;

import com.project.prepearindExam.models.Question;
import com.project.prepearindExam.service.ExaminerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/exam/get")
public class ExamController {
    private ExaminerService examinerService;

    @Autowired
    public ExamController(ExaminerService examinerService){
        this.examinerService = examinerService;
    }

    @GetMapping("/{amount}")
    public List<Question> getQuestions(@PathVariable int amount){
        return examinerService.getQuestions(amount);
    }

}
