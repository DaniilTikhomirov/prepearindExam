package com.project.prepearindExam.service;

import com.project.prepearindExam.exemples.OutOfRangeExeption;
import com.project.prepearindExam.models.Question;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;


@Service
public class ExaminerServiceImpl implements ExaminerService {
    private final QuestionService questionService;

    @Autowired
    public ExaminerServiceImpl(QuestionService questionService) {
        this.questionService = questionService;
    }

    @Override
    public List<Question> getQuestions(int amount) {
        if (amount > questionService.getQuestions().size()) {
            throw new OutOfRangeExeption();
        }
        List<Question> questions = new ArrayList<>();
        while (questions.size() < amount) {
            Question question = questionService.getRandomQuestion();
            if (!questions.contains(question)) {
                questions.add(question);
            }
        }
        return questions;
    }

}
