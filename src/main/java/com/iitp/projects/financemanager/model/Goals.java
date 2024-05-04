package com.iitp.projects.financemanager.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@Entity
public class Goals {
    @Id
    String goalId;
    int goalMonth;
    String goalDescription;
    LocalDateTime createdTimestamp;
    LocalDateTime updatedTimestamp;
    String userId;
}
