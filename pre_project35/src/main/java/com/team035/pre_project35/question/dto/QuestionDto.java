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

    @Getter
    @AllArgsConstructor
    public static class Patch {
        private int questionId;

        private String title;

        private String questionBody;

        public void setQuestionId(int questionId) {
            this.questionId = questionId;
        }
    }

    @Getter
    @AllArgsConstructor
    public static class Response {
        private int questionId;
        private String title;

        private String questionBody;

        private int viewCount;

        private int voteCount;

        public void setViewCount(int viewCount) {  //테스트위해 추가됨
            this.viewCount = viewCount;
        }

        public void setVoteCount(int voteCount) { //테스트위해 추가됨
            this.voteCount = voteCount;
        }
    }

}
