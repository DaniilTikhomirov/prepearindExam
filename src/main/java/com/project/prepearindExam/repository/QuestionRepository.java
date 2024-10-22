package com.project.prepearindExam.repository;

import com.project.prepearindExam.models.Question;

import java.util.ArrayList;

public interface QuestionRepository {
    void add(Question question);

    void remove(Question question);

    ArrayList<Question> getAll();
}
