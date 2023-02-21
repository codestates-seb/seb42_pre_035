package com.team035.pre_project35.user.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class UserPatchDto {

    private int userId;
    private String name;
    private String password;

    public void setUserId(int userId) {
        this.userId = userId;
    }
}
