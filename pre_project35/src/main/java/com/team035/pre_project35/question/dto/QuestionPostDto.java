package com.team035.pre_project35.question.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Positive;

@Getter
@AllArgsConstructor
public class QuestionPostDto {


    @Positive
    private int userId;

    @NotBlank(message = "공백이 아니어야 합니다.")
    private String title;

    @NotBlank(message = "공백이 아니어야 합니다.")
    private String questionBody;

}
