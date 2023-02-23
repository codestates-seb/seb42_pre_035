package com.team035.pre_project35.user.controller;

import com.team035.pre_project35.user.dto.UserDto;
import com.team035.pre_project35.user.entity.User;
import com.team035.pre_project35.user.mapper.UserMapper;
import com.team035.pre_project35.user.service.UserService;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.restdocs.AutoConfigureRestDocs;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.data.jpa.mapping.JpaMetamodelMappingContext;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.restdocs.constraints.ConstraintDescriptions;
import org.springframework.restdocs.payload.JsonFieldType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import com.google.gson.Gson;
import java.util.List;

import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.startsWith;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.doNothing;
import static org.springframework.restdocs.headers.HeaderDocumentation.headerWithName;
import static org.springframework.restdocs.headers.HeaderDocumentation.responseHeaders;
import static org.springframework.restdocs.mockmvc.RestDocumentationRequestBuilders.*;
import static org.springframework.restdocs.operation.preprocess.Preprocessors.*;
import static org.springframework.restdocs.operation.preprocess.Preprocessors.prettyPrint;
import static org.springframework.restdocs.request.RequestDocumentation.parameterWithName;
import static org.springframework.restdocs.request.RequestDocumentation.pathParameters;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static org.springframework.restdocs.mockmvc.MockMvcRestDocumentation.document;
import static org.springframework.restdocs.payload.PayloadDocumentation.*;



@WebMvcTest(UserController.class)
@MockBean(JpaMetamodelMappingContext.class)
@AutoConfigureRestDocs
public class UserControllerTest {
    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private UserService userService;

    @MockBean
    private UserMapper userMapper;

    @Autowired
    private Gson gson;

    @Test
    public void postUserTest() throws Exception{
        //given
        UserDto.Post post = new UserDto.Post("eee", "aaa@gmail.com", "1q2q3q4q");
        String content = gson.toJson(post);

        UserDto.Response responseDto =
                new UserDto.Response(1,"eee", "aaa@gmail.com", "1q2q3q4q");

        given(userMapper.userPostDtoToUser(Mockito.any(UserDto.Post.class))).willReturn(new User());
        User mockResultUser = new User();
        mockResultUser.setUserId(1);
        given(userService.createUser(Mockito.any(User.class))).willReturn(mockResultUser);

        given(userMapper.userToUserResponse(Mockito.any(User.class))).willReturn(responseDto);

        ResultActions actions =
                mockMvc.perform(post("/users")
                                .accept(MediaType.APPLICATION_JSON)
                                .contentType(MediaType.APPLICATION_JSON)
                                .content(content));


        actions
                .andExpect(status().isCreated())
                .andExpect(header().string("Location", is(startsWith("/users/"))))
                .andDo(document("post-user",
                        preprocessRequest(prettyPrint()),
                        preprocessResponse(prettyPrint()),
                        requestFields(
                                List.of(
                                        fieldWithPath("name").type(JsonFieldType.STRING).description("이름"),
                                        fieldWithPath("email").type(JsonFieldType.STRING).description("이메일"),
                                        fieldWithPath("password").type(JsonFieldType.STRING).description("패스워드")
                                )
                        ),
                        responseHeaders(
                                headerWithName(HttpHeaders.LOCATION).description("Location header . 등록된 리소스의 URI")
                        )
                ));
    }

    @Test
    public void patchUserTest() throws Exception {
        int userId = 1;

        UserDto.Patch patch = new UserDto.Patch(userId, "eee", "1q2q3q4q");
        String content = gson.toJson(patch);

        UserDto.Response response =
                new UserDto.Response(1, "eee", "aaa@gmail.com", "1q2q3q4q");

        given(userMapper.userPatchToUser(Mockito.any(UserDto.Patch.class))).willReturn(new User());
        given(userService.updateUser(Mockito.any(User.class))).willReturn(new User());
        given(userMapper.userToUserResponse(Mockito.any(User.class))).willReturn(response);

        ResultActions actions =
                mockMvc.perform(patch("/users/{user-id}", userId)
                        .accept(MediaType.APPLICATION_JSON)
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(content));
        ConstraintDescriptions patchUserConstraints = new ConstraintDescriptions(UserDto.Patch.class); // 유효성 검증 조건 정보 객체 생성
        List<String> nameDescriptions = patchUserConstraints.descriptionsForProperty("name"); // name 필드의 유효성 검증 정보 얻기
        List<String> passwordDescriptions = patchUserConstraints.descriptionsForProperty("password");

        actions
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.userId").value(patch.getUserId()))
                .andExpect(jsonPath("$.name").value(patch.getName()))
                .andExpect(jsonPath("$.password").value(patch.getPassword()))
                .andDo(document("patch-user",
                                preprocessRequest(prettyPrint()),
                                preprocessResponse(prettyPrint()),
                                pathParameters(
                                        parameterWithName("user-id").description("회원 식별자")
                                ),
                                requestFields(
                                        List.of(
                                                fieldWithPath("userId").type(JsonFieldType.NUMBER).description("회원 식별자").ignored(),
                                                fieldWithPath("name").type(JsonFieldType.STRING).description("이름").optional(),
                                                fieldWithPath("password").type(JsonFieldType.STRING).description("패스워드").optional()
                                        )
                                ),
                                responseFields(
                                        List.of(
                                                fieldWithPath("data").type(JsonFieldType.OBJECT).description("결과 데이터").optional(),
                                                fieldWithPath("userId").type(JsonFieldType.NUMBER).description("회원 식별자"),
                                                fieldWithPath("name").type(JsonFieldType.STRING).description("이름"),
                                                fieldWithPath("email").type(JsonFieldType.STRING).description("이메일"),
                                                fieldWithPath("password").type(JsonFieldType.STRING).description("패스워드")
                                        )
                                ))

                );


    }

    @Test
    public void getUserTest() throws Exception {

        int userId = 1;

        User user = new User("eee", "aaa@gmail.com", "1q2q3q4q");
        user.setUserId(userId);

        UserDto.Response response = new UserDto.Response(1, "eee", "aaa@gmail.com", "1q2q3q4q");

        given(userService.findUser(Mockito.anyInt())).willReturn(new User());
        given(userMapper.userToUserResponse(Mockito.any(User.class))).willReturn(response);

        ResultActions actions =
                mockMvc.perform(get("/users/{user-id}", userId).accept(MediaType.APPLICATION_JSON));
        actions.andExpect(status().isOk())
                .andExpect(jsonPath("$.name").value(user.getName()))
                .andExpect(jsonPath("$.email").value(user.getEmail()))
                .andExpect(jsonPath("$.password").value(user.getPassword()))
                .andDo(document("get-user",
                        pathParameters(
                                parameterWithName("user-id").description("회원 식별자")
                        ),
                        responseFields(
                                List.of(
                                        fieldWithPath("data").type(JsonFieldType.OBJECT).description("결과").optional(),
                                        fieldWithPath("userId").type(JsonFieldType.NUMBER).description("회원 식별자"),
                                        fieldWithPath("name").type(JsonFieldType.STRING).description("이름"),
                                        fieldWithPath("email").type(JsonFieldType.STRING).description("이메일"),
                                        fieldWithPath("password").type(JsonFieldType.STRING).description("패스워드")
                                )
                        )
                ));
    }

//    @Test
//    public void getUsersTest() throws Exception {
//        User user1 = new User("aaa", "eee@gmail.com", "1q2q3q4q");
//
//        User user2 = new User("bbb", "fff@gmail.com", "5q6q7q8q");
//
//        List<UserDto.Response> responses = List.of(
//                new UserDto.Response(1, "aaa", "eee@gmail.com", "1q2q3q4q"),
//                new UserDto.Response(2, "bbb", "fff@gmail.com", "5q6q7q8q")
//
//        );
//
//        given(userService.findUser())
//
//    }

    @Test
    public void deleteUser() throws Exception {
        int userId = 1;

        doNothing().when(userService).deleteUser(userId);

        ResultActions actions = mockMvc.perform(delete("/users/{user-id}", userId));
        actions.andExpect(status().isNoContent())
                .andDo(document("delete-user",
                        pathParameters(parameterWithName("user-id").description("회원 식별자"))));
    }
}