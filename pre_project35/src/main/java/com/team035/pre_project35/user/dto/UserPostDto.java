package com.team035.pre_project35.user.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

@Getter
@AllArgsConstructor
public class UserPostDto {

    private int userId;

    @NotBlank(message = "공백이 아니어야 합니다.")
    private String name;

    @NotBlank
    @Email
    private String email;

    @NotBlank(message = "공백이 아니어야 합니다.")
    private String password;

}
