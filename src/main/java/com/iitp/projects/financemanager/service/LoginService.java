package com.iitp.projects.financemanager.service;

import com.iitp.projects.financemanager.model.Login;
import com.iitp.projects.financemanager.security.user.CustomUserDetailsService;
import com.iitp.projects.financemanager.security.util.JwtUtil;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

@Service
public class LoginService {

    CustomUserDetailsService customUserDetailsService;
    JwtUtil jwtUtil;

    public LoginService(CustomUserDetailsService customUserDetailsService, JwtUtil jwtUtil){
        this.customUserDetailsService= customUserDetailsService;
        this.jwtUtil= jwtUtil;
    }

    public String loginUser(Login login) {
        UserDetails userDetails = customUserDetailsService.loadUserByUsername(login.getUsername());
        if (userDetails.getPassword().equals(login.getPassword())) {
            return jwtUtil.generateJwtToken(userDetails);
        }
        throw new RuntimeException("Invalid username/password");
    }
}
