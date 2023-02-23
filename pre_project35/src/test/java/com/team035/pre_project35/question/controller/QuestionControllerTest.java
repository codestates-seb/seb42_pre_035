package com.team035.pre_project35.question.controller;

import com.google.gson.Gson;
import com.team035.pre_project35.question.dto.QuestionDto;
import com.team035.pre_project35.question.entity.Question;
import com.team035.pre_project35.question.mapper.QuestionMapper;
import com.team035.pre_project35.question.service.QuestionService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.restdocs.AutoConfigureRestDocs;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.data.jpa.mapping.JpaMetamodelMappingContext;
import org.springframework.test.web.servlet.MockMvc;
import com.jayway.jsonpath.JsonPath;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.restdocs.AutoConfigureRestDocs;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.mapping.JpaMetamodelMappingContext;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.restdocs.constraints.ConstraintDescriptions;
import org.springframework.restdocs.mockmvc.RestDocumentationRequestBuilders;
import org.springframework.restdocs.payload.JsonFieldType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;

import java.util.Arrays;
import java.util.List;

import static com.team035.pre_project35.util.ApiDocumentUtils.*;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.startsWith;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.doNothing;
import static org.springframework.restdocs.headers.HeaderDocumentation.headerWithName;
import static org.springframework.restdocs.headers.HeaderDocumentation.responseHeaders;
import static org.springframework.restdocs.mockmvc.MockMvcRestDocumentation.document;
import static org.springframework.restdocs.mockmvc.RestDocumentationRequestBuilders.*;
import static org.springframework.restdocs.operation.preprocess.Preprocessors.*;
import static org.springframework.restdocs.payload.PayloadDocumentation.*;
import static org.springframework.restdocs.payload.PayloadDocumentation.fieldWithPath;
import static org.springframework.restdocs.request.RequestDocumentation.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;


@WebMvcTest(QuestionController.class)
@AutoConfigureRestDocs
@MockBean(JpaMetamodelMappingContext.class)
class QuestionControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private QuestionService questionService;

    @MockBean
    private QuestionMapper questionMapper;

    @Autowired
    private Gson gson;


    @Test
    public void postQuestionTest() throws Exception {
        QuestionDto.Post post = new QuestionDto.Post("title", "body");
        String content = gson.toJson(post);

        given(questionMapper.questionPostToQuestion(Mockito.any(QuestionDto.Post.class))).willReturn(new Question());

        Question mockResultQuestion = new Question();
        mockResultQuestion.setQuestionId(1);
        given(questionService.createQuestion(Mockito.any(Question.class))).willReturn(mockResultQuestion);

        ResultActions actions =
                mockMvc.perform(post("/questions")
                        .accept(MediaType.APPLICATION_JSON)
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(content));

        actions
                .andExpect(status().isCreated())
                .andExpect(header().string("Location" , is(startsWith("/questions/"))))
                .andDo(document(
                        "post-question",
                        getRequestPreProcessor(),
                        getResponsePreProcessor(),
                        requestFields(
                                List.of(
                                        fieldWithPath("title").type(JsonFieldType.STRING).description("타이틀"),
                                        fieldWithPath("questionBody").type(JsonFieldType.STRING).description("바디")
                                )
                        )
                        ,responseHeaders(
                                headerWithName(HttpHeaders.LOCATION).description("Location header")
                        )
                ));
    }
    @Test
    public void patchQuestionTest() throws Exception {
        int questionId = 1;

        QuestionDto.Patch patch = new QuestionDto.Patch(questionId, "title", "body");
        String content = gson.toJson(patch);

        QuestionDto.Response response =
                new QuestionDto.Response(1, "title", "body", 1, 1);

        given(questionMapper.questionPatchToQuestion(Mockito.any(QuestionDto.Patch.class))).willReturn(new Question());
        given(questionService.updateQuestion(Mockito.any(Question.class))).willReturn(new Question());
        given(questionMapper.questionToQuestionResponse(Mockito.any(Question.class))).willReturn(response);

        ResultActions actions =
                mockMvc.perform(patch("/questions/{question-id}", questionId)
                        .accept(MediaType.APPLICATION_JSON)
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(content));

        actions
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.title").value(patch.getTitle()))
                .andExpect(jsonPath("$.questionBody").value(patch.getQuestionBody()))
                .andDo(document("patch-question",
                        preprocessRequest(prettyPrint()),
                        preprocessResponse(),
                        pathParameters(
                                parameterWithName("question-id").description("질문식별")
                        ),
                        requestFields(
                                List.of(
                                        fieldWithPath("questionId").type(JsonFieldType.NUMBER).description("질문식별"),
                                        fieldWithPath("title").type(JsonFieldType.STRING).description("제목"),
                                        fieldWithPath("questionBody").type(JsonFieldType.STRING).description("내용")
                                )
                        ),
                        responseFields(
                                List.of(
                                        fieldWithPath("data").type(JsonFieldType.OBJECT).description("결과").optional(),
                                        fieldWithPath("questionId").type(JsonFieldType.NUMBER).description("질문식별"),
                                        fieldWithPath("title").type(JsonFieldType.STRING).description("제목"),
                                        fieldWithPath("questionBody").type(JsonFieldType.STRING).description("내용"),
                                        fieldWithPath("viewCount").type(JsonFieldType.NUMBER).description("조회수"),
                                        fieldWithPath("voteCount").type(JsonFieldType.NUMBER).description("좋아요수")
                                )
                        )
                ));

    }

    @Test
    public void getQuestionTest() throws Exception {
        int questionId = 1;
        Question question = new Question("title" ,"body");
        question.setQuestionId(questionId);

        QuestionDto.Response response = new QuestionDto.Response(1,
                "title", "body", 1, 1);

        given(questionService.findQuestion(Mockito.anyInt())).willReturn(new Question());
        given(questionMapper.questionToQuestionResponse(Mockito.any(Question.class))).willReturn(response);


        ResultActions actions = mockMvc.perform(
                get("/questions/{question-id}", questionId).accept(MediaType.APPLICATION_JSON)
        );

        actions.andExpect(status().isOk())
                .andExpect(jsonPath("$.title").value(question.getTitle()))
                .andExpect(jsonPath("$.questionBody").value(question.getQuestionBody()))
                .andDo(document("get-question",
                        pathParameters(
                                parameterWithName("question-id").description("질문식별")
                        ),
                        responseFields(
                                List.of(
                                        fieldWithPath("data").type(JsonFieldType.OBJECT).description("결과").optional(),
                                        fieldWithPath("questionId").type(JsonFieldType.NUMBER).description("질문식별"),
                                        fieldWithPath("title").type(JsonFieldType.STRING).description("제목"),
                                        fieldWithPath("questionBody").type(JsonFieldType.STRING).description("내용"),
                                        fieldWithPath("viewCount").type(JsonFieldType.NUMBER).description("조회수"),
                                        fieldWithPath("voteCount").type(JsonFieldType.NUMBER).description("좋아요수")
                                )
                        )
                ));
    }


    @Test
    public void getQuestionsTest() throws Exception {
        String page = "1";
        String size = "10";

        MultiValueMap<String, String> queryParams = new LinkedMultiValueMap<>();
        queryParams.add("page", page);
        queryParams.add("size", size);

        Question question1 = new Question("title1" , "body1");

        Question question2 = new Question("title2", "body2");

        Page<Question> pageQuestions =
                new PageImpl<>(List.of(question1, question2),
                        PageRequest.of(0, 10,
                                Sort.by("questionId").descending()), 2);

        List<QuestionDto.Response> responses = List.of(
                new QuestionDto.Response(1, "title1", "body1", 1, 1),
                new QuestionDto.Response(2, "title2", "body2", 2, 2
                ));

        given(questionService.findQuestions(Mockito.anyInt(), Mockito.anyInt()))
                .willReturn(pageQuestions);
        given(questionMapper.questionToQuestionResponses(Mockito.anyList()))
                .willReturn(responses);


        ResultActions actions = mockMvc.perform(RestDocumentationRequestBuilders.get("/questions")
                .params(queryParams).accept(MediaType.APPLICATION_JSON));


        MvcResult result = actions
                .andExpect(status().isOk())
                .andDo(document("get-questions", preprocessRequest(prettyPrint()), preprocessResponse(prettyPrint()),
                        requestParameters(
                                List.of(parameterWithName("page").description("page 번호"),
                                        parameterWithName("size").description("page size")
                                )
                        ),
                        responseFields(
                                List.of(
                                        fieldWithPath("data").type(JsonFieldType.ARRAY).description("결과데이터").optional(),
                                        fieldWithPath("data[].questionId").type(JsonFieldType.NUMBER).description("질문식별"),
                                        fieldWithPath("data[].title").type(JsonFieldType.STRING).description("제목"),
                                        fieldWithPath("data[].questionBody").type(JsonFieldType.STRING).description("내용"),
                                        fieldWithPath("data[].viewCount").type(JsonFieldType.NUMBER).description("조회수"),
                                        fieldWithPath("data[].voteCount").type(JsonFieldType.NUMBER).description("좋아요수"),
                                        fieldWithPath("pageInfo").type(JsonFieldType.OBJECT).description("페이지 정보"),
                                        fieldWithPath("pageInfo.page").type(JsonFieldType.NUMBER).description("페이지 번호"),
                                        fieldWithPath("pageInfo.size").type(JsonFieldType.NUMBER).description("페이지 사이즈"),
                                        fieldWithPath("pageInfo.totalElements").type(JsonFieldType.NUMBER).description("전체 건 수"),
                                        fieldWithPath("pageInfo.totalPages").type(JsonFieldType.NUMBER).description("전체 페이지 수")
                                )
                        )
                )).andReturn();

        List list = JsonPath.parse(result.getResponse().getContentAsString()).read("$.data");

        assertThat(list.size(), is(2));
    }

    @Test
    public void deleteQuestionTest() throws Exception{
        int questionId = 1;
        doNothing().when(questionService).deleteQuestion(Mockito.anyInt());

        // when
        ResultActions actions = mockMvc.perform(
                RestDocumentationRequestBuilders
                        .delete("/questions/{question-id}", questionId));
        // then
        actions.andExpect(status().isNoContent())
                .andDo(
                        document(
                                "delete-question",
                                preprocessRequest(prettyPrint()),
                                preprocessResponse(prettyPrint()),
                                pathParameters(
                                        Arrays.asList(parameterWithName("question-id").description("질문번호"))
                                )
                        )
                );
    }
}