package com.iitp.projects.financemanager.service;

import com.iitp.projects.financemanager.model.UserDetails;
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

    public List<UserDetails> fetchAllUserDetails() {
        return userRepository.findAll();
    }

    public void addUser(UserDetails userDetails) {
        userRepository.save(userDetails);
    }

    public void deleteUser(String userId) {
        userRepository.deleteById(userId);
    }

    public void updateUserDetails(UserDetails userDetails) {
        userRepository.save(userDetails);
    }

    public UserDetails fetchUserByUserId(String userId) throws Exception {
        Optional<UserDetails> userDetails = userRepository.findById(userId);
        if (userDetails.isPresent()) {
            return userDetails.get();
        }
        throw new Exception("User is not present in DB");
    }
}
