package com.team035.pre_project35.question.mapper;

import com.team035.pre_project35.question.dto.QuestionPatchDto;
import com.team035.pre_project35.question.dto.QuestionPostDto;
import com.team035.pre_project35.question.dto.QuestionResponseDto;
import com.team035.pre_project35.question.entity.Question;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2023-02-22T14:33:00+0900",
    comments = "version: 1.5.3.Final, compiler: javac, environment: Java 11.0.17 (Azul Systems, Inc.)"
)
@Component
public class QuestionMapperImpl implements QuestionMapper {

    @Override
    public Question questionPostDtoToQuestion(QuestionPostDto questionPostDto) {
        if ( questionPostDto == null ) {
            return null;
        }

        Question question = new Question();

        question.setTitle( questionPostDto.getTitle() );
        question.setQuestionBody( questionPostDto.getQuestionBody() );

        return question;
    }

    @Override
    public Question questionPatchDtoToQuestion(QuestionPatchDto questionPatchDto) {
        if ( questionPatchDto == null ) {
            return null;
        }

        Question question = new Question();

        question.setQuestionId( questionPatchDto.getQuestionId() );
        question.setTitle( questionPatchDto.getTitle() );
        question.setQuestionBody( questionPatchDto.getQuestionBody() );

        return question;
    }

    @Override
    public QuestionResponseDto questionToquestionResponseDto(Question question) {
        if ( question == null ) {
            return null;
        }

        int questionId = 0;
        String title = null;
        String questionBody = null;
        int viewCount = 0;
        int voteCount = 0;

        questionId = question.getQuestionId();
        title = question.getTitle();
        questionBody = question.getQuestionBody();
        viewCount = question.getViewCount();
        voteCount = question.getVoteCount();

        QuestionResponseDto questionResponseDto = new QuestionResponseDto( questionId, title, questionBody, viewCount, voteCount );

        return questionResponseDto;
    }

    @Override
    public List<QuestionResponseDto> questionToQuestionResponseDtos(List<Question> questions) {
        if ( questions == null ) {
            return null;
        }

        List<QuestionResponseDto> list = new ArrayList<QuestionResponseDto>( questions.size() );
        for ( Question question : questions ) {
            list.add( questionToquestionResponseDto( question ) );
        }

        return list;
    }
}
