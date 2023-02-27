package com.team035.pre_project35.user.service;

import com.team035.pre_project35.auth.utils.CustomAuthorityUtils;
import com.team035.pre_project35.exception.BusinessLogicException;
import com.team035.pre_project35.exception.ExceptionCode;
import com.team035.pre_project35.user.entity.User;
import com.team035.pre_project35.user.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final CustomAuthorityUtils authorityUtils;

    public User createUser(User user){

        verifyExistEmail(user.getEmail());

        //PasswordEncoder를 이용해 암호화후 할당
        String encryptedPassword = passwordEncoder.encode(user.getPassword());
        user.setPassword(encryptedPassword);

        //회원가입 시 User의 Role을 DB에 저장
        //회원의 권한정보 생성
        List<String> roles = authorityUtils.createRoles(user.getEmail());
        user.setRoles(roles);

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
        User findUser = user.orElseThrow(()-> new BusinessLogicException(ExceptionCode.USER_NOT_FOUND));

        return findUser;
    }

    public void verifyExistEmail(String email){
        Optional<User> user = userRepository.findByEmail(email);

        if(user.isPresent()){
            throw new BusinessLogicException(ExceptionCode.USER_EXISTS);
        }
    }

    public User getLoginUserWithToken(){
        //현재 인증된 사용자 정보
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();

       Optional<User> optionalUser = userRepository.findByEmail(authentication.getName());
       User user = optionalUser.orElseThrow(()-> new BusinessLogicException(ExceptionCode.USER_NOT_FOUND));

       return user;
    }
}
