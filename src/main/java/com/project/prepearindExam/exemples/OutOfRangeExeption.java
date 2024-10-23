package com.project.prepearindExam.exemples;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.BAD_REQUEST)
public class OutOfRangeExeption extends RuntimeException {
}
