package com.team035.pre_project35.answer.controller;

import com.google.gson.Gson;
import com.jayway.jsonpath.JsonPath;
import com.team035.pre_project35.answer.dto.AnswerDto;
import com.team035.pre_project35.answer.entity.Answer;
import com.team035.pre_project35.answer.mapper.AnswerMapper;
import com.team035.pre_project35.answer.service.AnswerService;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentMatchers;
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
import org.springframework.http.MediaType;
import org.springframework.restdocs.mockmvc.RestDocumentationRequestBuilders;
import org.springframework.restdocs.payload.JsonFieldType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;

import java.util.Arrays;
import java.util.List;

import static com.team035.pre_project35.util.ApiDocumentUtils.getRequestPreProcessor;
import static com.team035.pre_project35.util.ApiDocumentUtils.getResponsePreProcessor;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.startsWith;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.doNothing;
import static org.springframework.restdocs.headers.HeaderDocumentation.headerWithName;
import static org.springframework.restdocs.headers.HeaderDocumentation.responseHeaders;
import static org.springframework.restdocs.mockmvc.MockMvcRestDocumentation.document;
import static org.springframework.restdocs.mockmvc.RestDocumentationRequestBuilders.*;
import static org.springframework.restdocs.operation.preprocess.Preprocessors.*;
import static org.springframework.restdocs.payload.PayloadDocumentation.*;
import static org.springframework.restdocs.request.RequestDocumentation.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;

@WebMvcTest(AnswerController.class)
@AutoConfigureRestDocs
@MockBean(JpaMetamodelMappingContext.class)
class AnswerControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private AnswerService answerService;

    @MockBean
    private AnswerMapper answerMapper;

    @Autowired
    private Gson gson;

    @Test
    public void postAnswerTest() throws Exception {
        AnswerDto.Post post = new AnswerDto.Post("body");
        String content = gson.toJson(post);

        given(answerMapper.answerPostToAnswer(Mockito.any(AnswerDto.Post.class))).willReturn(new Answer());
        Answer answer = new Answer();
        answer.setAnswerId(1);
        given(answerService.createAnswer(Mockito.any(Answer.class))).willReturn(answer);


        ResultActions actions =
                mockMvc.perform(post("/answers")
                        .accept(MediaType.APPLICATION_JSON)
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(content));


        actions
                .andExpect(status().isCreated())
                .andExpect(header().string("Location" , is(startsWith("/answers/"))))
                .andDo(document("post-answer",
                        preprocessRequest(prettyPrint()),
                        preprocessResponse(prettyPrint()),
                        requestFields(
                                List.of(
                                        fieldWithPath("answerBody").type(JsonFieldType.STRING).description("내용")
                                )

                        ),
                        responseHeaders(
                                headerWithName(HttpHeaders.LOCATION).description("Location")
                        )
                        )
                );
    }

    @Test
    public void patchAnswerTest() throws Exception {
        int answerId = 1;

        AnswerDto.Patch patch = new AnswerDto.Patch(answerId, "body");
        String content = gson.toJson(patch);

        AnswerDto.Response response =
                new AnswerDto.Response( 1,"body");

        given(answerMapper.answerPatchToAnswer(Mockito.any(AnswerDto.Patch.class))).willReturn(new Answer());
        given(answerService.updateAnswer(Mockito.any(Answer.class))).willReturn(new Answer());
        given(answerMapper.answerToAnswerResponse(Mockito.any(Answer.class))).willReturn(response);

        ResultActions actions =
                mockMvc.perform(RestDocumentationRequestBuilders.patch("/answers/{answer-id}", answerId)
                        .accept(MediaType.APPLICATION_JSON)
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(content));

        actions
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.answerBody").value(patch.getAnswerBody()))
                .andDo(document("patch-answer",
                        preprocessRequest(prettyPrint()),
                        preprocessResponse(prettyPrint()),
                        pathParameters(
                                parameterWithName("answer-id").description("답변번호")
                        ),
                        requestFields(
                                List.of(
                                        fieldWithPath("answerId").type(JsonFieldType.NUMBER).description("답변번호"),
                                        fieldWithPath("answerBody").type(JsonFieldType.STRING).description("내용")
                                )
                        ),
                        responseFields(
                                List.of(
                                        fieldWithPath("data").type(JsonFieldType.OBJECT).description("결과").optional(),
                                        fieldWithPath("answerId").type(JsonFieldType.NUMBER).description("답변번호"),
                                        fieldWithPath("answerBody").type(JsonFieldType.STRING).description("내용")
                                )
                        )
                ));
    }

    @Test
    void getAnswers() throws Exception {
        String page = "1";
        String size = "10";

        MultiValueMap<String, String> queryParams = new LinkedMultiValueMap<>();
        queryParams.add("page", page);
        queryParams.add("size", size);

        Answer answer1 = new Answer("body1");

        Answer answer2 = new Answer("body2");

        Page<Answer> pageAnswers =
                new PageImpl<>(List.of(answer1, answer2),
                        PageRequest.of(0, 10,
                                Sort.by("answerId").descending()), 2);

        List<AnswerDto.Response> responses = List.of(
                new AnswerDto.Response(1,"body1"),
                new AnswerDto.Response(2,"body2"
                ));

        given(answerService.findAnswers(Mockito.anyInt(), Mockito.anyInt()))
                .willReturn(pageAnswers);
        given(answerMapper.answerToAnswerResponses(Mockito.anyList()))
                .willReturn(responses);


        ResultActions actions = mockMvc.perform(RestDocumentationRequestBuilders.get("/answers")
                .params(queryParams).accept(MediaType.APPLICATION_JSON));


        MvcResult result = actions
                .andExpect(status().isOk())
                .andDo(document("get-answers", preprocessRequest(prettyPrint()), preprocessResponse(prettyPrint()),
                        requestParameters(
                                List.of(parameterWithName("page").description("page 번호"),
                                        parameterWithName("size").description("page size")
                                )
                        ),
                        responseFields(
                                List.of(
                                        fieldWithPath("data").type(JsonFieldType.ARRAY).description("결과데이터").optional(),
                                        fieldWithPath("data[].answerId").type(JsonFieldType.NUMBER).description("답변번호").optional(),
                                        fieldWithPath("data[].answerBody").type(JsonFieldType.STRING).description("내용"),
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
    void deleteAnswer() throws Exception {
        int answerId = 1;
        doNothing().when(answerService).deleteAnswer(Mockito.anyInt());

        // when
        ResultActions actions = mockMvc.perform(
                RestDocumentationRequestBuilders
                        .delete("/answers/{answer-id}", answerId));
        // then
        actions.andExpect(status().isNoContent())
                .andDo(
                        document(
                                "delete-answer",
                                preprocessRequest(prettyPrint()),
                                preprocessResponse(prettyPrint()),
                                pathParameters(
                                        Arrays.asList(parameterWithName("answer-id").description("답변번호"))
                                )
                        )
                );
    }
}