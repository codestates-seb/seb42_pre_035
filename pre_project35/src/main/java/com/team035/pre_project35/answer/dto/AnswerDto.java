package com.team035.pre_project35.answer.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

public class AnswerDto {
    
    @Getter
    @AllArgsConstructor
    @NoArgsConstructor
    public static class Post {
        private String answerBody;
    }
    
    @Getter
    @AllArgsConstructor
    public static class Patch {
        private int answerId;
        private String answerBody;
    
        public void setAnswerId(int answerId) {
            this.answerId = answerId;
        }
    }
    
    @Getter
    @AllArgsConstructor
    public static class Response {
        private int answerId;
        private String answerBody;
        
    }
}
