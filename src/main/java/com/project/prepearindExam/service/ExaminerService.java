package com.project.prepearindExam.service;

import com.project.prepearindExam.models.Question;

import java.util.List;

public interface ExaminerService {
    List<Question> getQuestions(int amount);
}
