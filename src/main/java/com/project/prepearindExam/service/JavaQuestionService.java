package com.project.prepearindExam.service;

import com.project.prepearindExam.models.Question;
import com.project.prepearindExam.repository.QuestionRepository;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class JavaQuestionService implements QuestionService{
    private final QuestionRepository questionRepository;

    @Autowired
    public JavaQuestionService(@Qualifier("javaQuestionRepository") QuestionRepository questionRepository) {
        this.questionRepository = questionRepository;

    }

    @PostConstruct
    public void init() {
        for (int i = 0; i < 10; i++) {
            this.questionRepository.add(new Question("JavaQ" + i, "JavaA" + i));
        }
    }

    @Override
    public List<Question> getQuestions() {
        return questionRepository.getAll();
    }

    @Override
    public Question addQuestion(String answer, String question){
        Question questionClass = new Question(answer, question);
        questionRepository.add(questionClass);
        return questionClass;
    }

    @Override
    public Question removeQuestion(String answer, String question){
        Question questionClass = new Question(answer, question);
        this.questionRepository.remove(questionClass);
        return questionClass;
    }

    @Override
    public Question getRandomQuestion(){
        Random random = new Random();
        List<Question> questions = questionRepository.getAll();
        return questions.get(random.nextInt(questions.size()));
    }
}
