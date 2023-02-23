package com.team035.pre_project35.question.controller;

import com.team035.pre_project35.helper.UriCreator;
import com.team035.pre_project35.question.dto.QuestionDto;
import com.team035.pre_project35.question.entity.Question;
import com.team035.pre_project35.question.mapper.QuestionMapper;
import com.team035.pre_project35.question.service.QuestionService;
import com.team035.pre_project35.response.MultiResponseDto;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.Positive;
import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/questions")
@Validated
@RequiredArgsConstructor
public class QuestionController {

    private final static String QUESTION_DEFAULT_URL = "/questions";

    private final QuestionService questionService;

    private final QuestionMapper mapper;

    @PostMapping
    public ResponseEntity postQuestion (@Valid @RequestBody QuestionDto.Post requestBody){
        Question question = mapper.questionPostToQuestion(requestBody);

        Question createdQuestion = questionService.createQuestion(question);

        URI location = UriCreator.createUri(QUESTION_DEFAULT_URL, createdQuestion.getQuestionId());

        return ResponseEntity.created(location).build();
    }

    @PatchMapping("/{question-id}")
    public ResponseEntity patchQuestion (@PathVariable("question-id") @Positive int questionId,
                                         @RequestBody QuestionDto.Patch requestBody){

        requestBody.setQuestionId(questionId);

        Question question = questionService.updateQuestion(mapper.questionPatchToQuestion(requestBody));

        return new ResponseEntity<>(mapper.questionToQuestionResponse(question), HttpStatus.OK);
    }

    @GetMapping("/{question-id}")
    public ResponseEntity getQuestion(@PathVariable("question-id") @Positive int questionId){

        Question findquestion = questionService.findQuestion(questionId);
        questionService.updateQuestionViewCount(findquestion, findquestion.getViewCount());

        return new ResponseEntity<>(mapper.questionToQuestionResponse(findquestion), HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity getQuestions(@Positive @RequestParam int page,
                                       @Positive @RequestParam int size){
        Page<Question> pageQuestions = questionService.findQuestions(page - 1, size);
        List<Question> questions = pageQuestions.getContent();


        return new ResponseEntity<>(new MultiResponseDto<>(mapper.questionToQuestionResponses(questions),pageQuestions),
                HttpStatus.OK);
    }

    @DeleteMapping("/{question-id}")
    public ResponseEntity deleteQuestion(@PathVariable("question-id") @Positive int questionId){

        questionService.deleteQuestion(questionId);

        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

}
