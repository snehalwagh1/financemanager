package com.iitp.projects.financemanager.security.authprovider;

import com.iitp.projects.financemanager.security.authentication.UserAuthentication;
import com.iitp.projects.financemanager.security.user.CustomUserDetailsService;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

@Component
public class UserAuthProvider implements AuthenticationProvider {

    CustomUserDetailsService customUserDetailsService;

    public UserAuthProvider(CustomUserDetailsService customUserDetailsService) {
        this.customUserDetailsService = customUserDetailsService;
    }

    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
        UserDetails userDetails = customUserDetailsService.loadUserByUsername(authentication.getName());
        if (userDetails.getPassword().equals(authentication.getCredentials())) {
            return authentication;
        }
        throw new RuntimeException("Invalid username/password");
    }

    @Override
    public boolean supports(Class<?> authentication) {
        return authentication.equals(UserAuthentication.class);
    }
}
