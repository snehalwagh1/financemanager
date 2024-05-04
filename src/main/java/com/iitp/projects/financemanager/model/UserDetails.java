package com.iitp.projects.financemanager.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@Entity
public class UserDetails {
    @Id
    String userId;
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
