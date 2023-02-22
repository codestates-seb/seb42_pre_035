package com.team035.pre_project35.question.mapper;

import com.team035.pre_project35.question.dto.QuestionPatchDto;
import com.team035.pre_project35.question.dto.QuestionPostDto;
import com.team035.pre_project35.question.dto.QuestionResponseDto;
import com.team035.pre_project35.question.entity.Question;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface QuestionMapper {

    Question questionPostDtoToQuestion(QuestionPostDto questionPostDto);

    Question questionPatchDtoToQuestion(QuestionPatchDto questionPatchDto);

    QuestionResponseDto questionToquestionResponseDto(Question question);

    List<QuestionResponseDto> questionToQuestionResponseDtos(List<Question> questions);
}
