package com.team035.pre_project35.question.mapper;

import com.team035.pre_project35.question.dto.QuestionDto;
import com.team035.pre_project35.question.entity.Question;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2023-02-24T01:59:17+0900",
    comments = "version: 1.5.3.Final, compiler: javac, environment: Java 11.0.17 (Azul Systems, Inc.)"
)
@Component
public class QuestionMapperImpl implements QuestionMapper {

    @Override
    public Question questionPostToQuestion(QuestionDto.Post requestBody) {
        if ( requestBody == null ) {
            return null;
        }

        Question question = new Question();

        question.setTitle( requestBody.getTitle() );
        question.setQuestionBody( requestBody.getQuestionBody() );

        return question;
    }

    @Override
    public Question questionPatchToQuestion(QuestionDto.Patch requestBody) {
        if ( requestBody == null ) {
            return null;
        }

        Question question = new Question();

        question.setQuestionId( requestBody.getQuestionId() );
        question.setTitle( requestBody.getTitle() );
        question.setQuestionBody( requestBody.getQuestionBody() );

        return question;
    }

    @Override
    public QuestionDto.Response questionToQuestionResponse(Question question) {
        if ( question == null ) {
            return null;
        }

        int viewCount = 0;
        int voteCount = 0;
        int questionId = 0;
        String title = null;
        String questionBody = null;

        viewCount = question.getViewCount();
        voteCount = question.getVoteCount();
        questionId = question.getQuestionId();
        title = question.getTitle();
        questionBody = question.getQuestionBody();

        QuestionDto.Response response = new QuestionDto.Response( questionId, title, questionBody, viewCount, voteCount );

        return response;
    }

    @Override
    public List<QuestionDto.Response> questionToQuestionResponses(List<Question> questions) {
        if ( questions == null ) {
            return null;
        }

        List<QuestionDto.Response> list = new ArrayList<QuestionDto.Response>( questions.size() );
        for ( Question question : questions ) {
            list.add( questionToQuestionResponse( question ) );
        }

        return list;
    }
}
