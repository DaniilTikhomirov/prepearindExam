package com.project.prepearindExam;

import com.project.prepearindExam.models.Question;
import com.project.prepearindExam.repository.JavaQuestionRepository;
import com.project.prepearindExam.service.JavaQuestionService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class JavaQuestionServiceTest {

    @Mock
    private JavaQuestionRepository javaQuestionRepository;

    @InjectMocks
    private JavaQuestionService questionService;

    @Test
    public void getQuestionsTest(){
        Assertions.assertEquals(questionService.getQuestions().size(), 0);
    }

    @Test
    public void addQuestionTest(){
        when(javaQuestionRepository.getAll()).
                thenReturn(new ArrayList<>(List.of(new Question("q", "a"))));
        questionService.addQuestion("q", "a");
        Assertions.assertEquals(questionService.getQuestions().size(), 1);
    }

    @Test
    public void deleteQuestionTest(){
        javaQuestionRepository.add(new Question("q", "a"));
        javaQuestionRepository.remove(new Question("q", "a"));
        questionService.addQuestion("q", "a");
        questionService.removeQuestion("q", "a");
        Assertions.assertEquals(questionService.getQuestions().size(), 0);
    }

}
