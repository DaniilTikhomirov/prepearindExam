package com.project.prepearindExam.service;

import com.project.prepearindExam.models.Question;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class QuestionServiceImpl implements QuestionService{
    private final List<Question> questions;

    public QuestionServiceImpl() {
        this.questions = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            this.questions.add(new Question("q" + i, "a" + i));
        }
    }

    @Override
    public List<Question> getQuestions() {
        return questions;
    }

    @Override
    public Question addQuestion(String answer, String question){
        Question questionClass = new Question(answer, question);
        if (!questions.contains(questionClass)){
            this.questions.add(questionClass);
        }
        return questionClass;
    }

    @Override
    public Question removeQuestion(String answer, String question){
        Question questionClass = new Question(answer, question);
        this.questions.remove(questionClass);
        return questionClass;
    }

    @Override
    public Question getRandomQuestion(){
        Random random = new Random();
        return questions.get(random.nextInt(questions.size()));
    }
}
