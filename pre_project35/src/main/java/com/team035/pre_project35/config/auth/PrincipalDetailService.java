package com.team035.pre_project35.config.auth;

import com.team035.pre_project35.user.entity.User;
import com.team035.pre_project35.user.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class PrincipalDetailService implements UserDetailsService {
    private final UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {

        System.out.println("PrincipalDetailsService : 진입");
        Optional<User> userEntity  = userRepository.findByEmail(email);


        return new PrincipalDetails(userEntity.get());
    }

}
