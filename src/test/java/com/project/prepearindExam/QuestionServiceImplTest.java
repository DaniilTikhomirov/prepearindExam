package com.project.prepearindExam;

import com.project.prepearindExam.models.Question;
import com.project.prepearindExam.service.QuestionServiceImpl;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.params.provider.MethodSource;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Random;

import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.when;

public class QuestionServiceImplTest {

    private QuestionServiceImpl questionService;

    @BeforeEach
    public void setUp() {
        questionService = new QuestionServiceImpl();
    }




    @Test
    public void getQuestionsTest(){
        Assertions.assertEquals(questionService.getQuestions().size(), 10);
    }

    @Test
    public void addQuestionTest(){
        questionService.addQuestion("q", "a");
        Assertions.assertEquals(questionService.getQuestions().size(), 11);
    }

    @Test
    public void deleteQuestionTest(){
        questionService.addQuestion("q", "a");
        questionService.removeQuestion("q", "a");
        Assertions.assertEquals(questionService.getQuestions().size(), 10);
    }

}
