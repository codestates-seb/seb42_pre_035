package com.team035.pre_project35.user.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class UserResponseDto {

    private int userId;

    private String name;

    private String email;

    private String password;
}
