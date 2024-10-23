package com.project.prepearindExam.repository;

import com.project.prepearindExam.models.Question;
import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;

@Repository
public class JavaQuestionRepository implements QuestionRepository {
    private ArrayList<Question> questions;

    public JavaQuestionRepository() {
        this.questions = new ArrayList<>();

    }


    @Override
    public void add(Question question) {
        if (!this.questions.contains(question)) {
            this.questions.add(question);
        }
    }

    @Override
    public void remove(Question question) {
        this.questions.remove(question);
    }

    @Override
    public ArrayList<Question> getAll() {
        return this.questions;
    }
}
