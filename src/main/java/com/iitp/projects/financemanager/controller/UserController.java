package com.iitp.projects.financemanager.controller;

import com.iitp.projects.financemanager.model.UserData;
import com.iitp.projects.financemanager.service.UserDetailsService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
@Slf4j
public class UserController {

    UserDetailsService userDetailsService;

    public UserController(UserDetailsService userDetailsService) {
        this.userDetailsService = userDetailsService;
    }

    @GetMapping("/fetchAllUsers")
    public ResponseEntity<List<UserData>> fetchAllUserDetailsList() {
        log.info("fetching all user details service");
        return new ResponseEntity<>(userDetailsService.fetchAllUserDetails(), HttpStatus.OK);
    }

    @GetMapping("/fetchUserWithUserId/{userId}")
    public ResponseEntity<UserData> fetchUserWithUserDetails(@PathVariable String userId) throws Exception {
        log.info("fetching all user details service");
        return new ResponseEntity<>(userDetailsService.fetchUserByUserId(userId), HttpStatus.OK);
    }

    @PostMapping("/addUser")
    public ResponseEntity<String> addUser(@RequestBody UserData userData) {
        log.info("adding user");
        userDetailsService.addUser(userData);
        return new ResponseEntity<>("Success", HttpStatus.OK);
    }

    @GetMapping("/deleteUser/{userId}")
    public ResponseEntity<String> deleteUser(@PathVariable String userId) {
        userDetailsService.deleteUser(userId);
        return new ResponseEntity<>("Success", HttpStatus.OK);
    }

    @PostMapping("/updateUser")
    public ResponseEntity<String> updateUserDetails(@RequestBody UserData userData) {
        userDetailsService.updateUserDetails(userData);
        return new ResponseEntity<>("Success", HttpStatus.OK);
    }
}
