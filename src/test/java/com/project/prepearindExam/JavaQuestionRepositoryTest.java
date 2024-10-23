package com.project.prepearindExam;

import com.project.prepearindExam.models.Question;
import com.project.prepearindExam.repository.JavaQuestionRepository;
import org.junit.Before;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class JavaQuestionRepositoryTest {
    JavaQuestionRepository repo;

    @BeforeEach
    public void setUp() {
        repo = new JavaQuestionRepository();
    }

    @Test
    public void testAdd() {
        repo.add(new Question("q", "a"));
        repo.add(new Question("q", "a"));
        Assertions.assertEquals(1, repo.getAll().size());
    }

    @Test
    public void testRemove() {
        repo.add(new Question("q", "a"));
        repo.remove(new Question("q", "a"));
    }

    @Test
    public void testGetAll() {
        repo.add(new Question("q", "a"));
        repo.add(new Question("q", "b"));
        repo.add(new Question("q", "c"));
        Assertions.assertEquals(3, repo.getAll().size());
    }
}
