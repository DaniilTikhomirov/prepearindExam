package com.project.prepearindExam;

import com.project.prepearindExam.models.Question;
import com.project.prepearindExam.service.ExaminerService;
import com.project.prepearindExam.service.ExaminerServiceImpl;
import com.project.prepearindExam.service.QuestionServiceImpl;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.params.provider.MethodSource;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class ExaminerServiceImplTest {

    @Mock
    QuestionServiceImpl questionServiceImpl;

    @InjectMocks
    ExaminerServiceImpl examinerService;

    @Test
    @MethodSource("getRandomQuestion")
    public void getQuestionsTest() {
        Question question = new Question("q", "a");
        List<Question> questions = new ArrayList<>();
        questions.add(question);
        when(questionServiceImpl.getRandomQuestion()).thenReturn(question);
        when(questionServiceImpl.getQuestions()).thenReturn(questions);
        Assertions.assertEquals(examinerService.getQuestions(1), new ArrayList<Question>(List.of(question)));
    }


}
