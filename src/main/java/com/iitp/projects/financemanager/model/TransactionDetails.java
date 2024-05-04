package com.iitp.projects.financemanager.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@Entity
public class TransactionDetails {
    @Id
    String transactionId;
    String userId;
    String transactionCategory;
    String accountId;
    int amount;
    LocalDateTime createdTimestamp;
    LocalDateTime updatedTimestamp;
}
