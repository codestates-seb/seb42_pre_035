package com.team035.pre_project35.question.mapper;

import com.team035.pre_project35.answer.dto.AnswerResponseDto;
import com.team035.pre_project35.answer.entity.Answer;
import com.team035.pre_project35.question.dto.QuestionPatchDto;
import com.team035.pre_project35.question.dto.QuestionPostDto;
import com.team035.pre_project35.question.dto.QuestionResponseDto;
import com.team035.pre_project35.question.entity.Question;
import org.mapstruct.Mapper;

import java.util.List;
import java.util.stream.Collectors;

@Mapper(componentModel = "spring")
public interface QuestionMapper {

    Question questionPostDtoToQuestion(QuestionPostDto questionPostDto);

    Question questionPatchDtoToQuestion(QuestionPatchDto questionPatchDto);

    default QuestionResponseDto questionToquestionResponseDto(Question question){

        if ( question == null ) {
            return null;
        }

        QuestionResponseDto questionResponseDto = new QuestionResponseDto();
//        questionResponseDto.setUserId(question.getUser().getUserId());
        questionResponseDto.setQuestionId(question.getQuestionId());
        questionResponseDto.setTitle(question.getTitle());
        questionResponseDto.setQuestionBody(question.getQuestionBody());
        questionResponseDto.setViewCount(question.getViewCount());
        questionResponseDto.setVoteCount(question.getVoteCount());

        List<Answer> answerList = question.getAnswers();
        List<AnswerResponseDto> answerResponseDtoList = answerList.stream().map(answer -> {
            AnswerResponseDto answerResponseDto = new AnswerResponseDto();
            answerResponseDto.setAnswerId(answer.getAnswerId());
            answerResponseDto.setAnswerBody(answer.getAnswerBody());
            return answerResponseDto;
        }).collect(Collectors.toList());

        questionResponseDto.setAnswers(answerResponseDtoList);

        return questionResponseDto;
    }

    List<QuestionResponseDto> questionToQuestionResponseDtos(List<Question> questions);
}
