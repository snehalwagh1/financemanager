package com.iitp.projects.financemanager.security.filter;

import com.iitp.projects.financemanager.model.UserData;
import com.iitp.projects.financemanager.security.authentication.JwtAuthentication;
import com.iitp.projects.financemanager.security.authentication.UserAuthentication;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;

@Component
@Slf4j
public class UserAuthFilter extends OncePerRequestFilter {
    AuthenticationManager authenticationManager;

    public UserAuthFilter(AuthenticationManager authenticationManager) {
        this.authenticationManager = authenticationManager;
    }

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        log.info("executing filter");
        String username = request.getHeader("username");
        String password = request.getHeader("password");
        String token= request.getHeader("token");
        log.info("username: "+username+" :: password: "+password+" :: token: "+token);
        if(token != null){
            log.info("authenticating with token");
            Authentication authentication= authenticationManager.authenticate(new JwtAuthentication(username, token));
            SecurityContextHolder.getContext().setAuthentication(authentication);
        }else{
            log.info("authenticating with password");
            UserAuthentication authentication= (UserAuthentication) authenticationManager.authenticate(new UserAuthentication(new UserData(username, password)));
            response.setHeader("token", authentication.getToken());
            SecurityContextHolder.getContext().setAuthentication(authentication);
            return;
        }
        filterChain.doFilter(request, response);
    }

    @Override
    protected boolean shouldNotFilter(HttpServletRequest request) throws ServletException {
        log.info("the addUser and login request should not be filtered: uri: " + request.getRequestURI());
        return (request.getRequestURI().equals("/user/addUser")
                | request.getRequestURI().equalsIgnoreCase("/auth/login"));
    }
}
