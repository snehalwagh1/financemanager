package com.iitp.projects.financemanager.security.user;

import com.iitp.projects.financemanager.model.UserData;
import com.iitp.projects.financemanager.repository.UserRepository;
import com.iitp.projects.financemanager.security.mapper.UserDetailsMapper;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

@Component
public class CustomUserDetailsService implements UserDetailsService {

    UserRepository userRepository;
    UserDetailsMapper userDetailsMapper;

    public CustomUserDetailsService(UserRepository userRepository, UserDetailsMapper userDetailsMapper) {
        this.userRepository = userRepository;
        this.userDetailsMapper = userDetailsMapper;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        UserData userData = userRepository.findByUsername(username);
        return userDetailsMapper.mapToUserDetails(userData);
    }
}
