package com.iitp.projects.financemanager.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@Entity
public class AccountDetails {
    @Id
    String accountId;
    String userId;
    String bankName;
    String backIfscCode;
    String accountNumber;
    int balance;
    LocalDateTime createdTimestamp;
    LocalDateTime updatedTimestamp;
}
