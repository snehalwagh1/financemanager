package com.iitp.projects.financemanager.security.authprovider;

import com.iitp.projects.financemanager.security.authentication.JwtAuthentication;
import com.iitp.projects.financemanager.security.user.CustomUserDetailsService;
import com.iitp.projects.financemanager.security.util.JwtUtil;
import com.iitp.projects.financemanager.service.UserDetailsService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class JwtAuthenticationProvider implements AuthenticationProvider {

    CustomUserDetailsService customUserDetailsService;
    JwtUtil jwtUtil;

    public JwtAuthenticationProvider(CustomUserDetailsService customUserDetailsService, JwtUtil jwtUtil){
        this.customUserDetailsService= customUserDetailsService;
        this.jwtUtil= jwtUtil;
    }
    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
        log.info("authenticating JWT token");
        log.info("username: "+authentication.getPrincipal());
        UserDetails userDetails= customUserDetailsService.loadUserByUsername(authentication.getName());
        if(jwtUtil.validateJwtToken((String) authentication.getCredentials(), userDetails)){
            return authentication;
        }
        throw new RuntimeException("Token is invalid");
    }

    @Override
    public boolean supports(Class<?> authentication) {
        return authentication.equals(JwtAuthentication.class);
    }
}
