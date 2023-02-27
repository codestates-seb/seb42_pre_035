package com.team035.pre_project35.user.mapper;

import com.team035.pre_project35.user.dto.UserDto;
import com.team035.pre_project35.user.entity.User;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

import java.util.List;

@Mapper(componentModel = "spring" ,unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface UserMapper {

    User userPostDtoToUser(UserDto.Post requestBody);

    User userPatchToUser(UserDto.Patch requestBody);

    UserDto.Response userToUserResponse(User user);

    List<UserDto.Response> usersToUserResponses(List<User> users);
}
