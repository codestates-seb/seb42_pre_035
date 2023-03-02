package com.team035.pre_project35.question.dto;

import com.team035.pre_project35.answer.dto.AnswerResponseDto;
import lombok.Getter;
import lombok.Setter;
import java.util.List;

@Getter
@Setter
public class QuestionResponseDto {

    private int userId;
    private int questionId;
    private String title;

    private String questionBody;

    private int viewCount;

    private int voteCount;

    private List<AnswerResponseDto> answers;
}
