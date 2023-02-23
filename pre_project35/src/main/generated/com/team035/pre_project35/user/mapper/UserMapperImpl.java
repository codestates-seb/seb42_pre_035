package com.team035.pre_project35.user.mapper;

import com.team035.pre_project35.user.dto.UserPatchDto;
import com.team035.pre_project35.user.dto.UserPostDto;
import com.team035.pre_project35.user.dto.UserResponseDto;
import com.team035.pre_project35.user.entity.User;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2023-02-22T14:33:00+0900",
    comments = "version: 1.5.3.Final, compiler: javac, environment: Java 11.0.17 (Azul Systems, Inc.)"
)
@Component
public class UserMapperImpl implements UserMapper {

    @Override
    public User userPostDtoToUser(UserPostDto userPostDto) {
        if ( userPostDto == null ) {
            return null;
        }

        User user = new User();

        user.setName( userPostDto.getName() );
        user.setEmail( userPostDto.getEmail() );
        user.setPassword( userPostDto.getPassword() );

        return user;
    }

    @Override
    public User userPatchDtoToUser(UserPatchDto userPatchDto) {
        if ( userPatchDto == null ) {
            return null;
        }

        User user = new User();

        user.setUserId( userPatchDto.getUserId() );
        user.setName( userPatchDto.getName() );
        user.setPassword( userPatchDto.getPassword() );

        return user;
    }

    @Override
    public UserResponseDto userToUserResponseDto(User user) {
        if ( user == null ) {
            return null;
        }

        int userId = 0;
        String name = null;
        String email = null;
        String password = null;

        userId = user.getUserId();
        name = user.getName();
        email = user.getEmail();
        password = user.getPassword();

        UserResponseDto userResponseDto = new UserResponseDto( userId, name, email, password );

        return userResponseDto;
    }
}
