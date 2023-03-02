package com.team035.pre_project35.user.mapper;

import com.team035.pre_project35.user.dto.UserPatchDto;
import com.team035.pre_project35.user.dto.UserPostDto;
import com.team035.pre_project35.user.dto.UserResponseDto;
import com.team035.pre_project35.user.entity.User;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

import java.util.List;

@Mapper(componentModel = "spring" ,unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface UserMapper {

    User userPostDtoToUser(UserPostDto userPostDto);

    User userPatchToUser(UserPatchDto userPatchDto);

    UserResponseDto userToUserResponse(User user);

    List<UserResponseDto> usersToUserResponses(List<User> users);
}
