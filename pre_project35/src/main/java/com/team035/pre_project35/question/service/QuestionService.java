package com.team035.pre_project35.question.service;

import com.team035.pre_project35.answer.entity.Answer;
import com.team035.pre_project35.question.entity.Question;
import com.team035.pre_project35.question.repository.QuestionRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class QuestionService {

    private final QuestionRepository questionRepository;

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

    public List<Question> findQuestions() {

        return questionRepository.findAll();
    }

    public void deleteQuestion(int questionId) {

        Question question = verifiedQuestion(questionId);
        questionRepository.delete(question);
    }

    public Question verifiedQuestion(int questionId) {

        Optional<Question> question = questionRepository.findById(questionId);
        Question findQuestion = question.orElseThrow(() -> new RuntimeException("Not found question"));

        return findQuestion;
    }

    public void updateQuestionViewCount(Question question, int viewCount){
        question.setViewCount(viewCount + 1);
        questionRepository.save(question);
    }
}
