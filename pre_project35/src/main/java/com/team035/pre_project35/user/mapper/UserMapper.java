package com.team035.pre_project35.user.mapper;

import com.team035.pre_project35.user.dto.UserDto;
import com.team035.pre_project35.user.entity.User;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface UserMapper {

    User userPostDtoToUser(UserDto.Post requestBody);

    User userPatchToUser(UserDto.Patch requestBody);

    UserDto.Response userToUserResponse(User user);
}
