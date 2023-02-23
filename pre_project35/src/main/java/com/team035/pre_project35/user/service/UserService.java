package com.team035.pre_project35.user.service;

import com.team035.pre_project35.exception.BusinessLogicException;
import com.team035.pre_project35.exception.ExceptionCode;
import com.team035.pre_project35.user.entity.User;
import com.team035.pre_project35.user.repository.UserRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
@Transactional
public class UserService {

    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public User createUser(User user){
        User saveUser = userRepository.save(user);

        return saveUser;
    }
    @Transactional(propagation = Propagation.REQUIRED , isolation = Isolation.SERIALIZABLE)
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
        User findUser = user.orElseThrow(()-> new BusinessLogicException(ExceptionCode.USER_EXISTS));

        return findUser;
    }
}
