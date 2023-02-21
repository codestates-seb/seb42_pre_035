package com.team035.pre_project35.answer.service;

import com.team035.pre_project35.answer.entity.Answer;
import com.team035.pre_project35.answer.repository.AnswerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class AnswerService {


    private final AnswerRepository answerRepository;

    public Answer createAnswer (Answer answer){

        return answerRepository.save(answer);
    }

    public Answer updateAnswer (Answer answer){

        Answer findAnswer = verifiedAnswer(answer.getAnswerId());

        //null이 아니라면 answerbody를 업데이트
        Optional.ofNullable(answer.getAnswerBody())
                .ifPresent(answerBody -> findAnswer.setAnswerBody(answerBody));

        return answerRepository.save(findAnswer);
    }

    public Answer findAnswer (int answerId){

        return verifiedAnswer(answerId);
    }

    public List<Answer> findAnswers(){

        return answerRepository.findAll();
    }

    public void deleteAnswer(int answerId){

        Answer answer = verifiedAnswer(answerId);
        answerRepository.delete(answer);
    }

    public Answer verifiedAnswer(int answerId){

        Optional<Answer> findAnswer = answerRepository.findById(answerId);
        Answer answer = findAnswer.orElseThrow(()-> new RuntimeException("not found answer"));

        return answer;
    }
}
