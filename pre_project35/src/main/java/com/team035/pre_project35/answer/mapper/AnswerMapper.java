package com.team035.pre_project35.answer.mapper;

import com.team035.pre_project35.answer.dto.AnswerDto;
import com.team035.pre_project35.answer.entity.Answer;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

import java.util.List;

@Mapper(componentModel = "spring" , unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface AnswerMapper {

    Answer answerPostToAnswer(AnswerDto.Post requestBody);

    Answer answerPatchToAnswer(AnswerDto.Patch requestBody);

    AnswerDto.Response answerToAnswerResponse(Answer answer);

    List<AnswerDto.Response> answerToAnswerResponses(List<Answer> answers);
}
