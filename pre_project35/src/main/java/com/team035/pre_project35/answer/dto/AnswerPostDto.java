package com.team035.pre_project35.answer.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;

@Getter
@AllArgsConstructor
@NoArgsConstructor  //인자 1개일때 추가해줘야함
public class AnswerPostDto {

    @NotBlank
    private String answerBody;
}
