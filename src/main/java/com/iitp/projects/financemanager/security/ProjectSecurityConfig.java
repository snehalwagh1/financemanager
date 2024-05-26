package com.iitp.projects.financemanager.security;

import com.iitp.projects.financemanager.security.authprovider.JwtAuthenticationProvider;
import com.iitp.projects.financemanager.security.authprovider.UserAuthProvider;
import com.iitp.projects.financemanager.security.filter.UserAuthFilter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.www.BasicAuthenticationFilter;

@Configuration
@Slf4j
public class ProjectSecurityConfig {
    UserAuthProvider userAuthProvider;
    JwtAuthenticationProvider jwtAuthenticationProvider;

    public ProjectSecurityConfig(UserAuthProvider userAuthProvider, JwtAuthenticationProvider jwtAuthenticationProvider) {
        this.userAuthProvider = userAuthProvider;
        this.jwtAuthenticationProvider= jwtAuthenticationProvider;
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return NoOpPasswordEncoder.getInstance();
    }

    @Bean
    public AuthenticationManager authenticationManager(HttpSecurity httpSecurity) throws Exception {
        AuthenticationManagerBuilder authenticationManagerBuilder = httpSecurity.getSharedObject(AuthenticationManagerBuilder.class);
        authenticationManagerBuilder.authenticationProvider(userAuthProvider);
        authenticationManagerBuilder.authenticationProvider(jwtAuthenticationProvider);
        return authenticationManagerBuilder.build();
    }

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity httpSecurity) throws Exception {
        httpSecurity
                .authorizeHttpRequests(auth -> {
                    auth.anyRequest().permitAll();
                })
                .csrf(AbstractHttpConfigurer::disable)
                .addFilterAt(new UserAuthFilter(authenticationManager(httpSecurity)), BasicAuthenticationFilter.class);
        return httpSecurity.build();
    }
}