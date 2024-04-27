package com.iitp.projects.financemanager.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@Entity
public class AccountDetails {
    @Id
    String account_id;
    String user_id;
    String bank_name;
    String back_ifsc_code;
    String account_number;
    int balance;
    LocalDateTime created_timestamp;
    LocalDateTime updated_timestamp;
}
