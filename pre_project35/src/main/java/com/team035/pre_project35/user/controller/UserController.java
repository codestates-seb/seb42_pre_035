package com.team035.pre_project35.user.controller;

import com.team035.pre_project35.helper.UriCreator;
import com.team035.pre_project35.user.dto.UserPatchDto;
import com.team035.pre_project35.user.dto.UserPostDto;
import com.team035.pre_project35.user.entity.User;
import com.team035.pre_project35.user.mapper.UserMapper;
import com.team035.pre_project35.user.service.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.Positive;
import java.net.URI;

@RestController
@RequestMapping("/users")
@Validated
public class UserController {

    private final static String USER_DEFAULT_URL = "/users";
    private final UserService userService;

    private final UserMapper mapper;

    public UserController(UserService userService, UserMapper mapper) {
        this.userService = userService;
        this.mapper = mapper;
    }

    @PostMapping
    public ResponseEntity postUser(@Valid @RequestBody UserPostDto userPostDto){

        User createUser = userService.createUser(mapper.userPostDtoToUser(userPostDto));

        URI location = UriCreator.createUri(USER_DEFAULT_URL, createUser.getUserId());

        return ResponseEntity.created(location).build();

    }

    @PatchMapping("/{user-id}")
    public ResponseEntity patchUser(@PathVariable("user-id") @Positive int userId,
                                    @Valid @RequestBody UserPatchDto userPatchDto){

        userPatchDto.setUserId(userId);

        User updateUser = userService.updateUser(mapper.userPatchToUser(userPatchDto));

        return new ResponseEntity<>(mapper.userToUserResponse(updateUser), HttpStatus.OK);
    }

    @GetMapping("/{user-id}")
    public ResponseEntity getUser(@PathVariable("user-id") @Positive int userId){

        User findUser = userService.findUser(userId);
        return new ResponseEntity<>(mapper.userToUserResponse(findUser), HttpStatus.OK);
    }


    @DeleteMapping("/{user-id}")
    public ResponseEntity deleteUser(@PathVariable("user-id") @Positive int userId){

        userService.deleteUser(userId);

        return new ResponseEntity(HttpStatus.NO_CONTENT);
    }
}
