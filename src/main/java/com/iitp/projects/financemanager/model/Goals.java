package com.iitp.projects.financemanager.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@Entity
public class Goals {
    @Id
    String goal_id;
    int goal_month;
    String goal_description;
    LocalDateTime created_timestamp;
    LocalDateTime updated_timestamp;
    String user_id;
}
