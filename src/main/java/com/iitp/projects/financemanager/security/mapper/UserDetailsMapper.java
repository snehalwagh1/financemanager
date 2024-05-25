package com.iitp.projects.financemanager.security.mapper;

import com.iitp.projects.financemanager.model.UserData;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

@Component
public class UserDetailsMapper {

    public UserDetails mapToUserDetails(UserData userData) {
        if (userData == null) {
            throw new RuntimeException("User not present");
        }
        return User.builder()
                .username(userData.getUsername())
                .password(userData.getPassword())
                .build();
    }
}
