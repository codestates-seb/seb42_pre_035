package com.team035.pre_project35.question.controller;

import com.team035.pre_project35.question.dto.QuestionPatchDto;
import com.team035.pre_project35.question.dto.QuestionPostDto;
import com.team035.pre_project35.question.entity.Question;
import com.team035.pre_project35.question.mapper.QuestionMapper;
import com.team035.pre_project35.question.service.QuestionService;
import com.team035.pre_project35.response.MultiResponseDto;
import com.team035.pre_project35.response.PageInfo;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.Positive;
import java.util.List;

@RestController
@RequestMapping("/questions")
@Validated
@RequiredArgsConstructor
public class QuestionController {

    private final QuestionService questionService;

    private final QuestionMapper mapper;

    @PostMapping
    public ResponseEntity postQuestion (@Valid @RequestBody QuestionPostDto questionPostDto){
        Question question = questionService.createQuestion(mapper.questionPostDtoToQuestion(questionPostDto));

        return new ResponseEntity<>(mapper.questionToquestionResponseDto(question), HttpStatus.CREATED);
    }

    @PatchMapping("/{question-id}")
    public ResponseEntity patchQuestion (@PathVariable("question-id") @Positive int questionId,
                                         @RequestBody QuestionPatchDto questionPatchDto){

        questionPatchDto.setQuestionId(questionId);

        Question question = questionService.updateQuestion(mapper.questionPatchDtoToQuestion(questionPatchDto));

        return new ResponseEntity<>(mapper.questionToquestionResponseDto(question), HttpStatus.OK);
    }

    @GetMapping("/{question-id}")
    public ResponseEntity getQuestion(@PathVariable("question-id") @Positive int questionId){

        Question findquestion = questionService.findQuestion(questionId);
        questionService.updateQuestionViewCount(findquestion, findquestion.getViewCount());

        return new ResponseEntity<>(mapper.questionToquestionResponseDto(findquestion), HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity getQuestions(@Positive @RequestParam int page,
                                       @Positive @RequestParam int size){
        Page<Question> pageQuestions = questionService.findQuestions(page - 1, size);
        List<Question> questions = pageQuestions.getContent();

        PageInfo pageInfo = new PageInfo(page, size, (int) pageQuestions.getTotalElements(), pageQuestions.getTotalPages());

        return new ResponseEntity<>(new MultiResponseDto<>(mapper.questionToQuestionResponseDtos(questions), pageInfo), HttpStatus.OK);
    }

    @DeleteMapping("/{question-id}")
    public ResponseEntity deleteQuestion(@PathVariable("question-id") @Positive int questionId){

        questionService.deleteQuestion(questionId);

        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

}
