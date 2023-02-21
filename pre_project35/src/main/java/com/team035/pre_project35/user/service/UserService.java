package com.team035.pre_project35.user.service;

import com.team035.pre_project35.user.entity.User;
import com.team035.pre_project35.user.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;

    public User createUser(User user){

        return userRepository.save(user);
    }

    public User updateUser(User user){

        User findUser = verifiedUser(user.getUserId());

        Optional.ofNullable(user.getName())
                .ifPresent(userName -> findUser.setName(userName));
        Optional.ofNullable(user.getPassword())
                .ifPresent(userPassword -> findUser.setPassword(userPassword));

        return userRepository.save(findUser);
    }

    public void deleteUser(int userId){

        User user = verifiedUser(userId);

        userRepository.delete(user);
    }

    public User findUser(int userId){

        return verifiedUser(userId);
    }

    public User verifiedUser(int userId){

        Optional<User> user = userRepository.findById(userId);
        User findUser = user.orElseThrow(()-> new RuntimeException("Not found"));

        return findUser;
    }
}
