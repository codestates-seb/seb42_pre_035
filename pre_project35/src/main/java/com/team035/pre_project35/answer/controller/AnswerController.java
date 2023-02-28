package com.team035.pre_project35.answer.controller;

import com.team035.pre_project35.answer.dto.AnswerDto;
import com.team035.pre_project35.answer.entity.Answer;
import com.team035.pre_project35.answer.mapper.AnswerMapper;
import com.team035.pre_project35.answer.service.AnswerService;
import com.team035.pre_project35.helper.UriCreator;
import com.team035.pre_project35.response.MultiResponseDto;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
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
@RequestMapping("/answers")
@Validated
@Slf4j

public class AnswerController {
    private final static String ANSWER_DEFAULT_URL = "/answers";
    private final AnswerService answerService;

    private final AnswerMapper mapper;
    public AnswerController(AnswerService answerService, AnswerMapper mapper) {
        this.answerService = answerService;
        this.mapper = mapper;
    }
    @PostMapping
    public ResponseEntity postAnswer(@Valid @RequestBody AnswerDto.Post requestBody){
        Answer answer = mapper.answerPostToAnswer(requestBody);

        Answer createdAnswer = answerService.createAnswer(answer);

        URI location = UriCreator.createUri(ANSWER_DEFAULT_URL, createdAnswer.getAnswerId());

        return ResponseEntity.created(location).build();
    }

    @PatchMapping("/{answer-id}")
    public ResponseEntity patchAnswer(@PathVariable("answer-id") @Positive int answerId,
                                      @Valid @RequestBody AnswerDto.Patch requestBody){

        requestBody.setAnswerId(answerId);

        Answer answer = answerService.updateAnswer(mapper.answerPatchToAnswer(requestBody));

        return new ResponseEntity<>(mapper.answerToAnswerResponse(answer),HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity getAnswers(@Positive @RequestParam int page,
                                     @Positive @RequestParam int size){

        Page<Answer> pageAnswer = answerService.findAnswers(page - 1, size);
        List<Answer> answers = pageAnswer.getContent();


        return new ResponseEntity<>(new MultiResponseDto<>(mapper.answerToAnswerResponses(answers), pageAnswer), HttpStatus.OK);
    }

    @DeleteMapping("/{answer-id}")
    public ResponseEntity deleteAnswer(@PathVariable("answer-id") @Positive int answerId){

        answerService.deleteAnswer(answerId);

        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }


}
