package com.iitp.projects.financemanager.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class UserData {


    public UserData(String username, String password) {
        this.username = username;
        this.password = password;
    }

    @Id
    String userId;
    String username;
    String firstName;
    String lastName;
    String email;
    String password;
    String accountId;
    String mobileNumber;
    String address;
    LocalDateTime createTimestamp;
    LocalDateTime updatedTimestamp;
}
