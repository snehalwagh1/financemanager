package com.iitp.projects.financemanager.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@Entity
public class TransactionDetails {
    @Id
    String transaction_id;
    String user_id;
    String transaction_category;
    String account_id;
    int amount;
    LocalDateTime created_timestamp;
    LocalDateTime updated_timestamp;
}
