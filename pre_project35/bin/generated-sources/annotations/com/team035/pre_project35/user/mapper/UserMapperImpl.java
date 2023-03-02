package com.team035.pre_project35.user.mapper;

import com.team035.pre_project35.user.dto.UserPatchDto;
import com.team035.pre_project35.user.dto.UserPostDto;
import com.team035.pre_project35.user.dto.UserResponseDto;
import com.team035.pre_project35.user.entity.User;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2023-03-02T18:41:58+0900",
    comments = "version: 1.5.3.Final, compiler: Eclipse JDT (IDE) 3.33.0.v20230213-1046, environment: Java 17.0.6 (Eclipse Adoptium)"
)
@Component
public class UserMapperImpl implements UserMapper {

    @Override
    public User userPostDtoToUser(UserPostDto userPostDto) {
        if ( userPostDto == null ) {
            return null;
        }

        User user = new User();

        user.setEmail( userPostDto.getEmail() );
        user.setName( userPostDto.getName() );
        user.setPassword( userPostDto.getPassword() );

        return user;
    }

    @Override
    public User userPatchToUser(UserPatchDto userPatchDto) {
        if ( userPatchDto == null ) {
            return null;
        }

        User user = new User();

        user.setName( userPatchDto.getName() );
        user.setPassword( userPatchDto.getPassword() );
        user.setUserId( userPatchDto.getUserId() );

        return user;
    }

    @Override
    public UserResponseDto userToUserResponse(User user) {
        if ( user == null ) {
            return null;
        }

        UserResponseDto.UserResponseDtoBuilder userResponseDto = UserResponseDto.builder();

        userResponseDto.email( user.getEmail() );
        userResponseDto.name( user.getName() );
        userResponseDto.password( user.getPassword() );
        userResponseDto.userId( user.getUserId() );

        return userResponseDto.build();
    }

    @Override
    public List<UserResponseDto> usersToUserResponses(List<User> users) {
        if ( users == null ) {
            return null;
        }

        List<UserResponseDto> list = new ArrayList<UserResponseDto>( users.size() );
        for ( User user : users ) {
            list.add( userToUserResponse( user ) );
        }

        return list;
    }
}
