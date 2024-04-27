package com.iitp.projects.financemanager.repository;

import com.iitp.projects.financemanager.model.TransactionDetails;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TransactionRepository extends JpaRepository<TransactionDetails, String> {
    List<TransactionDetails> findAllByUserId(List<String> userId);
}
