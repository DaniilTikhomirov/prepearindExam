package com.project.prepearindExam.exemples;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.METHOD_NOT_ALLOWED)
public class MethodNotAllowed extends RuntimeException {
}
