package com.team035.pre_project35.exception;

import lombok.Getter;

public enum ExceptionCode {

    USER_NOT_FOUND(404, "User not found"),

    USER_EXISTS(409, "User exists"),

    QUESTION_NOT_FOUND(404 , "Question not found"),

    ANSWER_NOT_FOUND(404 , "Answer not found");

    @Getter
    private int status;

    @Getter
    private String message;

    ExceptionCode(int status, String message) {
        this.status = status;
        this.message = message;
    }
}
