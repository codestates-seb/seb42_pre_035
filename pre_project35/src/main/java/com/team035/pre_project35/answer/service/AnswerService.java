package com.team035.pre_project35.answer.service;

import com.team035.pre_project35.answer.entity.Answer;
import com.team035.pre_project35.answer.repository.AnswerRepository;
import com.team035.pre_project35.exception.BusinessLogicException;
import com.team035.pre_project35.exception.ExceptionCode;
import com.team035.pre_project35.question.service.QuestionService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;
@Transactional
@Service
@RequiredArgsConstructor
public class AnswerService {


    private final AnswerRepository answerRepository;
    private final QuestionService questionService;

    public Answer createAnswer (Answer answer, int questionId){

        answer.addQuestion(questionService.findQuestion(questionId));
        return answerRepository.save(answer);
    }

    public Answer updateAnswer (Answer answer){

        Answer findAnswer = verifiedAnswer(answer.getAnswerId());

        //null이 아니라면 answerbody를 업데이트
        Optional.ofNullable(answer.getAnswerBody())
                .ifPresent(answerBody -> findAnswer.setAnswerBody(answerBody));

        return answerRepository.save(findAnswer);
    }

//    public Answer findAnswer (int answerId){
//
//        return verifiedAnswer(answerId);
//    }
//
//    //페이지네이션 answerId asc
//    public Page<Answer> findAnswers(int page, int size){
//
//        return answerRepository.findAll(PageRequest.of(page, size, Sort.by("answerId").ascending()));
//    }

    public void deleteAnswer(int answerId){

        Answer answer = verifiedAnswer(answerId);
        answerRepository.delete(answer);
    }

    public Answer verifiedAnswer(int answerId){

        Optional<Answer> findAnswer = answerRepository.findById(answerId);
        Answer answer = findAnswer.orElseThrow(()-> new BusinessLogicException(ExceptionCode.ANSWER_NOT_FOUND));

        return answer;
    }
}
