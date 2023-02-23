package com.team035.pre_project35.question.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class QuestionResponseDto {

    private int questionId;
    private String title;

    private String questionBody;

    private int viewCount;

    private int voteCount;

}
