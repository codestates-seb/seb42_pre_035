package com.team035.pre_project35.question.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class QuestionPatchDto {

    private int userId;
    private int questionId;

    private String title;

    private String questionBody;

    public void setQuestionId(int questionId) {
        this.questionId = questionId;
    }
}
