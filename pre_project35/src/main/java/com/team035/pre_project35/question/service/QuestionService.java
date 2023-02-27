package com.team035.pre_project35.question.service;

import com.team035.pre_project35.exception.BusinessLogicException;
import com.team035.pre_project35.exception.ExceptionCode;
import com.team035.pre_project35.question.entity.Question;
import com.team035.pre_project35.question.repository.QuestionRepository;
import com.team035.pre_project35.user.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class QuestionService {

    private final QuestionRepository questionRepository;
    final int SIZE = 30;

    public Question createQuestion(Question question) {

        return questionRepository.save(question);
    }

    public Question updateQuestion(Question question) {


        //존재하는 질문인지
        Question findQuestion = verifiedQuestion(question.getQuestionId());

        //null이 아니라면 title, questionBody 업데이트
        Optional.ofNullable(question.getTitle())
                .ifPresent(questionTitle -> findQuestion.setTitle(questionTitle));
        Optional.ofNullable(question.getQuestionBody())
                .ifPresent(questionBody -> findQuestion.setQuestionBody(questionBody));

        return questionRepository.save(findQuestion);
    }

    public Question findQuestion(int questionId) {

        return verifiedQuestion(questionId);
    }

    //페이지네이션 questionId desc
    public Page<Question> findQuestions(int page) {

        return questionRepository.findAll(PageRequest.of(page, SIZE, Sort.by("questionId").descending()));
    }

    public void deleteQuestion(int questionId) {

        Question question = verifiedQuestion(questionId);
        questionRepository.delete(question);
    }

    public Question verifiedQuestion(int questionId) {

        Optional<Question> question = questionRepository.findById(questionId);
        Question findQuestion = question.orElseThrow(() ->
                new BusinessLogicException(ExceptionCode.QUESTION_NOT_FOUND));

        return findQuestion;
    }

    public void updateQuestionViewCount(Question question, int viewCount){
        question.setViewCount(viewCount + 1);
        questionRepository.save(question);
    }

    // 검색 기능
    public Page<Question> searchQuestions(int page, String keyword){

        return questionRepository.findByTitleContainingIgnoreCase(PageRequest.of(page, SIZE), keyword);
    }
}
