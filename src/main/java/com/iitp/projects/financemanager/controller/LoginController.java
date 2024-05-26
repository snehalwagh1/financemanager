package com.iitp.projects.financemanager.controller;

import com.iitp.projects.financemanager.model.Login;
import com.iitp.projects.financemanager.service.LoginService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
@Slf4j
@CrossOrigin(origins = "http://localhost:9007")
public class LoginController {

    LoginService loginService;

    public LoginController(LoginService loginService){
        this.loginService= loginService;
    }


    @PostMapping("/login")
    public String login(@RequestBody Login login){
        log.info("login controller");
        return loginService.loginUser(login);
    }
}
