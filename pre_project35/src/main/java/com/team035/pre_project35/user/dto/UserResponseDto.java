package com.team035.pre_project35.user.dto;

import lombok.Builder;
import lombok.Getter;



@Builder
@Getter
public class UserResponseDto {

    private int userId;

    private String name;

    private String email;

    private String password;
}
