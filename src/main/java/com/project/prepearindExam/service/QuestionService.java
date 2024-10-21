package com.project.prepearindExam.service;

import com.project.prepearindExam.models.Question;

import java.util.List;

public interface QuestionService {
    List<Question> getQuestions();
    Question addQuestion(String answer, String question);
    Question removeQuestion(String answer, String question);
    Question getRandomQuestion();
}
