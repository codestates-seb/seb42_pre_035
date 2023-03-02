package com.team035.pre_project35.answer.mapper;

import com.team035.pre_project35.answer.dto.AnswerPatchDto;
import com.team035.pre_project35.answer.dto.AnswerPostDto;
import com.team035.pre_project35.answer.dto.AnswerResponseDto;
import com.team035.pre_project35.answer.entity.Answer;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

import java.util.List;

@Mapper(componentModel = "spring" , unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface AnswerMapper {

    Answer answerPostDtoToAnswer(AnswerPostDto answerPostDto);

    Answer answerPatchDtoToAnswer(AnswerPatchDto answerPatchDto);

    AnswerResponseDto answerToAnswerResponse(Answer answer);

    List<AnswerResponseDto> answerToAnswerResponses(List<Answer> answers);
}
