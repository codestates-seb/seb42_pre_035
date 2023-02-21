package com.team035.pre_project35.answer.controller;

import com.team035.pre_project35.answer.dto.AnswerPatchDto;
import com.team035.pre_project35.answer.dto.AnswerPostDto;
import com.team035.pre_project35.answer.entity.Answer;
import com.team035.pre_project35.answer.mapper.AnswerMapper;
import com.team035.pre_project35.answer.service.AnswerService;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.Positive;
import java.util.List;

@RestController
@RequestMapping("/answers")
@RequiredArgsConstructor
public class AnswerController {

    private final AnswerService answerService;

    private final AnswerMapper mapper;

    @PostMapping
    public ResponseEntity postAnswer(@Valid @RequestBody AnswerPostDto answerPostDto){

        Answer answer = answerService.createAnswer(mapper.ansewerPostDtoToAnswer(answerPostDto));

        return new ResponseEntity<>(mapper.answerToAnswerResponseDto(answer), HttpStatus.CREATED);
    }

    @PatchMapping("/{answer-id}")
    public ResponseEntity patchAnswer(@PathVariable("answer-id") @Positive int answerId,
                                      @Valid @RequestBody AnswerPatchDto answerPatchDto){

        answerPatchDto.setAnswerId(answerId);

        Answer answer = answerService.updateAnswer(mapper.answerPatchDtoToAnswer(answerPatchDto));

        return new ResponseEntity<>(mapper.answerToAnswerResponseDto(answer),HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity getAnswers(){

        List<Answer> answer = answerService.findAnswers();

        return new ResponseEntity<>(mapper.answerToResponseDtos(answer), HttpStatus.OK);
    }

    @DeleteMapping("/{answer-Id}")
    public ResponseEntity deleteAnswer(@PathVariable("answer-id") @Positive int answerId){

        answerService.deleteAnswer(answerId);

        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }


}
