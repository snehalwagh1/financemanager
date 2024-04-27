package com.iitp.projects.financemanager.repository;

import com.iitp.projects.financemanager.model.AccountDetails;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AccountRepository extends JpaRepository<AccountDetails, String> {
    AccountDetails findByAccountNumber(String accountNumber);

    List<AccountDetails> findByUserId(String userId);
}
