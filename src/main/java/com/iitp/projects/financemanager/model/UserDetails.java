package com.iitp.projects.financemanager.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@Entity
public class UserDetails {
    @Id
    String user_id;
    String first_name;
    String last_name;
    String email;
    String password;
    String account_id;
    String mobile_number;
    String address;
    LocalDateTime create_timestamp;
    LocalDateTime updated_timestamp;
}
