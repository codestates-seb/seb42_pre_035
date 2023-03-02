package com.team035.pre_project35.answer.mapper;

import com.team035.pre_project35.answer.dto.AnswerPatchDto;
import com.team035.pre_project35.answer.dto.AnswerPostDto;
import com.team035.pre_project35.answer.dto.AnswerResponseDto;
import com.team035.pre_project35.answer.entity.Answer;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2023-03-02T18:41:57+0900",
    comments = "version: 1.5.3.Final, compiler: Eclipse JDT (IDE) 3.33.0.v20230213-1046, environment: Java 17.0.6 (Eclipse Adoptium)"
)
@Component
public class AnswerMapperImpl implements AnswerMapper {

    @Override
    public Answer answerPostDtoToAnswer(AnswerPostDto answerPostDto) {
        if ( answerPostDto == null ) {
            return null;
        }

        Answer answer = new Answer();

        answer.setAnswerBody( answerPostDto.getAnswerBody() );

        return answer;
    }

    @Override
    public Answer answerPatchDtoToAnswer(AnswerPatchDto answerPatchDto) {
        if ( answerPatchDto == null ) {
            return null;
        }

        Answer answer = new Answer();

        answer.setAnswerBody( answerPatchDto.getAnswerBody() );
        answer.setAnswerId( answerPatchDto.getAnswerId() );

        return answer;
    }

    @Override
    public AnswerResponseDto answerToAnswerResponse(Answer answer) {
        if ( answer == null ) {
            return null;
        }

        AnswerResponseDto answerResponseDto = new AnswerResponseDto();

        answerResponseDto.setAnswerBody( answer.getAnswerBody() );
        answerResponseDto.setAnswerId( answer.getAnswerId() );

        return answerResponseDto;
    }

    @Override
    public List<AnswerResponseDto> answerToAnswerResponses(List<Answer> answers) {
        if ( answers == null ) {
            return null;
        }

        List<AnswerResponseDto> list = new ArrayList<AnswerResponseDto>( answers.size() );
        for ( Answer answer : answers ) {
            list.add( answerToAnswerResponse( answer ) );
        }

        return list;
    }
}
