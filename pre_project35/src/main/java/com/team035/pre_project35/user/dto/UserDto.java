package com.team035.pre_project35.user.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

public class UserDto {

    @Getter
    @AllArgsConstructor
    public static class Post {
        @NotBlank(message = "공백이 아니어야 합니다.")
        private String name;

        @NotBlank
        @Email
        private String email;

        @NotBlank(message = "공백이 아니어야 합니다.")
        private String password;
    }

    @AllArgsConstructor
    @Getter
    public static class Response{
        private int userId;

        private String name;

        private String email;

        private String password;
    }

    @Getter
    @AllArgsConstructor
    public static class Patch {
        private int userId;
        private String name;
        private String password;

        public void setUserId(int userId) {
            this.userId = userId;
        }
    }

}
