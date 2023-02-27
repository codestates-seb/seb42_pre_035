package com.team035.pre_project35.user.mapper;

import com.team035.pre_project35.user.dto.UserDto;
import com.team035.pre_project35.user.entity.User;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2023-02-24T01:59:17+0900",
    comments = "version: 1.5.3.Final, compiler: javac, environment: Java 11.0.17 (Azul Systems, Inc.)"
)
@Component
public class UserMapperImpl implements UserMapper {

    @Override
    public User userPostDtoToUser(UserDto.Post requestBody) {
        if ( requestBody == null ) {
            return null;
        }

        User user = new User();

        user.setName( requestBody.getName() );
        user.setEmail( requestBody.getEmail() );
        user.setPassword( requestBody.getPassword() );

        return user;
    }

    @Override
    public User userPatchToUser(UserDto.Patch requestBody) {
        if ( requestBody == null ) {
            return null;
        }

        User user = new User();

        user.setUserId( requestBody.getUserId() );
        user.setName( requestBody.getName() );
        user.setPassword( requestBody.getPassword() );

        return user;
    }

    @Override
    public UserDto.Response userToUserResponse(User user) {
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

        UserDto.Response response = new UserDto.Response( userId, name, email, password );

        return response;
    }

    @Override
    public List<UserDto.Response> usersToUserResponses(List<User> users) {
        if ( users == null ) {
            return null;
        }

        List<UserDto.Response> list = new ArrayList<UserDto.Response>( users.size() );
        for ( User user : users ) {
            list.add( userToUserResponse( user ) );
        }

        return list;
    }
}
