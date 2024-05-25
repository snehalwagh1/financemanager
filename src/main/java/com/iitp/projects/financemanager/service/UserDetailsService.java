package com.iitp.projects.financemanager.service;

import com.iitp.projects.financemanager.model.UserData;
import com.iitp.projects.financemanager.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserDetailsService {

    UserRepository userRepository;

    public UserDetailsService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public List<UserData> fetchAllUserDetails() {
        return userRepository.findAll();
    }

    public void addUser(UserData userData) {
        userRepository.save(userData);
    }

    public void deleteUser(String userId) {
        userRepository.deleteById(userId);
    }

    public void updateUserDetails(UserData userData) {
        userRepository.save(userData);
    }

    public UserData fetchUserByUserId(String userId) throws Exception {
        Optional<UserData> userDetails = userRepository.findById(userId);
        if (userDetails.isPresent()) {
            return userDetails.get();
        }
        throw new Exception("User is not present in DB");
    }
}
