package com.team035.pre_project35.advice;

import com.team035.pre_project35.response.ErrorResponse;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javax.validation.ConstraintViolationException;

@RestControllerAdvice
public class GlobalExceptionAdvice {
    @ExceptionHandler
    public ErrorResponse handleMethodArgumentNotValidException(
            MethodArgumentNotValidException e) {

        return ErrorResponse.of(e.getBindingResult());

    }

    @ExceptionHandler
    public ErrorResponse handleConstraintViolationException(
            ConstraintViolationException e) {

        return ErrorResponse.of(e.getConstraintViolations());

    }
}
