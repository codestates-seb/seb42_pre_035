package com.team035.pre_project35.answer.controller;

import com.team035.pre_project35.answer.dto.AnswerPatchDto;
import com.team035.pre_project35.answer.dto.AnswerPostDto;
import com.team035.pre_project35.answer.entity.Answer;
import com.team035.pre_project35.answer.mapper.AnswerMapper;
import com.team035.pre_project35.answer.service.AnswerService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.Positive;

@RestController
@RequestMapping("/questions")
@RequiredArgsConstructor
public class AnswerController {

    private final AnswerService answerService;

    private final AnswerMapper mapper;

    @PostMapping("/{question-id}")
    public ResponseEntity postAnswer(@PathVariable("question-id") @Positive int questionId,
                                     @Valid @RequestBody AnswerPostDto answerPostDto){

        Answer answer = answerService.createAnswer(mapper.answerPostDtoToAnswer(answerPostDto), questionId);

        return new ResponseEntity<>(mapper.answerToAnswerResponse(answer), HttpStatus.CREATED);
    }

    @PatchMapping("/{question-id}/{answer-id}")
    public ResponseEntity patchAnswer(@PathVariable("question-id") @Positive int questionId,
                                      @PathVariable("answer-id") @Positive int answerId,
                                      @Valid @RequestBody AnswerPatchDto answerPatchDto){

        answerPatchDto.setAnswerId(answerId);

        Answer answer = answerService.updateAnswer(mapper.answerPatchDtoToAnswer(answerPatchDto));

        return new ResponseEntity<>(mapper.answerToAnswerResponse(answer),HttpStatus.OK);
    }

    @DeleteMapping("/{question-id}/{answer-Id}")
    public ResponseEntity deleteAnswer(@PathVariable @Positive int questionId,
                                       @PathVariable("answer-id") @Positive int answerId){

        answerService.deleteAnswer(answerId);

        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
