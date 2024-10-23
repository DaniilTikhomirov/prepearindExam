package com.project.prepearindExam;

import com.project.prepearindExam.exemples.OutOfRangeExeption;
import com.project.prepearindExam.models.Question;
import com.project.prepearindExam.service.ExaminerServiceImpl;
import com.project.prepearindExam.service.JavaQuestionService;
import org.junit.Rule;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.params.provider.MethodSource;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnit;
import org.mockito.junit.MockitoRule;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class ExaminerServiceImplTest {

    @Rule
    public MockitoRule initRule = MockitoJUnit.rule();

    @Mock
    Random random;

    @Mock
    JavaQuestionService javaQuestionService;


    @InjectMocks
    ExaminerServiceImpl examinerService;

    @Test
    @MethodSource({"getRandomQuestion", "nextBoolean"})
    public void getQuestionsTest1() {
        Question question = new Question("q", "a");
        List<Question> questions = new ArrayList<>();
        questions.add(question);
        when(random.nextInt(anyInt())).thenReturn(0);
        when(javaQuestionService.getRandomQuestion()).thenReturn(question);
        when(javaQuestionService.getQuestions()).thenReturn(questions);
        Assertions.assertEquals(examinerService.getQuestions(1), new ArrayList<Question>(List.of(question)));
    }

    @Test
    @MethodSource({"getRandomQuestion", "nextBoolean"})
    public void getQuestionsTest2() {
        Question question = new Question("1 - 2", "-1");
        List<Question> questions = new ArrayList<>();
        questions.add(question);
        when(random.nextInt(anyInt())).thenReturn(1);
        when(javaQuestionService.getQuestions()).thenReturn(questions);
        Assertions.assertEquals(examinerService.getQuestions(1), new ArrayList<Question>(List.of(question)));
    }

    @Test
    @MethodSource({"getRandomQuestion", "nextBoolean"})
    public void getQuestionsTestError() {
        Question question = new Question("1 - 2", "-1");
        List<Question> questions = new ArrayList<>();
        questions.add(question);
        when(javaQuestionService.getQuestions()).thenReturn(questions);
        Assertions.assertThrows(OutOfRangeExeption.class, () -> examinerService.getQuestions(100));
    }


}
