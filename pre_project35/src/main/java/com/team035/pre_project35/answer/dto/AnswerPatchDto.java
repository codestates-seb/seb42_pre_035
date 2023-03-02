package com.team035.pre_project35.answer.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class AnswerPatchDto {

    private int answerId;
    private String answerBody;

    public void setAnswerId(int answerId) {
        this.answerId = answerId;
    }
}
