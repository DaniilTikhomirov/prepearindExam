package com.project.prepearindExam.controller;

import com.project.prepearindExam.exemples.MethodNotAllowed;
import com.project.prepearindExam.models.Question;
import com.project.prepearindExam.service.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/exam/math")
public class MathQuestionController {

    @GetMapping("/add")
    public void add(@RequestParam(value = "question", required = false) String question,
                        @RequestParam(value = "answer", required = false) String answer){
        throw new MethodNotAllowed();
    }

    @DeleteMapping("/remove")
    public void remove(@RequestParam(value = "question", required = false) String question,
                           @RequestParam(value = "answer", required = false) String answer){
        throw new MethodNotAllowed();
    }

    @GetMapping()
    public void allQuestion(){
        throw new MethodNotAllowed();
    }
}
