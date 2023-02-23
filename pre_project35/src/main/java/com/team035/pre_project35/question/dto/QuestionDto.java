package com.team035.pre_project35.question.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;

import javax.validation.constraints.NotBlank;

public class QuestionDto {

    @Getter
    @AllArgsConstructor
    public static class Post {
        @NotBlank(message = "공백이 아니어야 합니다.")
        private String title;

        @NotBlank(message = "공백이 아니어야 합니다.")
        private String questionBody;
    }
}
