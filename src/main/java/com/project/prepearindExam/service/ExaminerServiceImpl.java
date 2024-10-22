package com.project.prepearindExam.service;

import com.project.prepearindExam.exemples.OutOfRangeExeption;
import com.project.prepearindExam.models.Question;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;


@Service
public class ExaminerServiceImpl implements ExaminerService {
    private final QuestionService questionServiceJava;
    Random random;

    @Autowired
    public ExaminerServiceImpl(@Qualifier("javaQuestionService") QuestionService questionServiceJava) {
        this.questionServiceJava = questionServiceJava;
        this.random = new Random();
    }

    public ExaminerServiceImpl(QuestionService questionService, Random random) {
        this.questionServiceJava = questionService;
        this.random = random;
    }

    private Question getRandomMathQuestion() {
        int path = random.nextInt(4);
        int num1 = random.nextInt(1000);
        int num2 = random.nextInt(1000) + 1;
        return switch (path) {
            case 0 -> new Question(num1 + " + " + num2, String.valueOf(num1 + num2));
            case 1 -> new Question(num1 + " - " + num2, String.valueOf(num1 - num2));
            case 2 -> new Question(num1 + " * " + num2, String.valueOf(num1 * num2));
            default -> new Question(num1 + " / " + num2, String.valueOf(num1 / num2));
        };
    }

    @Override
    public List<Question> getQuestions(int amount) {
        int size = questionServiceJava.getQuestions().size() * 2;
        if (amount > size) {
            throw new OutOfRangeExeption();
        }
        List<Question> questions = new ArrayList<>();
        while (questions.size() < amount) {
            int path = random.nextInt(2);
            Question question;
            if (path == 0) {
                question = questionServiceJava.getRandomQuestion();
            }else {
                question = getRandomMathQuestion();
            }
            if (!questions.contains(question)) {
                questions.add(question);
            }
        }
        return questions;
    }

}
