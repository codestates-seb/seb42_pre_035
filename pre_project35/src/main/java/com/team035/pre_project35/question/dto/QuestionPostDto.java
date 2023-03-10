package com.team035.pre_project35.question.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotBlank;

@Getter
@Setter
@AllArgsConstructor
public class QuestionPostDto {

    private int userId;
    @NotBlank(message = "공백이 아니어야 합니다.")
    private String title;

    @NotBlank(message = "공백이 아니어야 합니다.")
    private String questionBody;

}
