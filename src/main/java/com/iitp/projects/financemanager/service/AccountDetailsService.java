package com.iitp.projects.financemanager.service;

import com.iitp.projects.financemanager.model.AccountDetails;
import com.iitp.projects.financemanager.repository.AccountRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AccountDetailsService {

    AccountRepository accountRepository;

    public AccountDetailsService(AccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }

    public AccountDetails getAccDetailsByAccNum(String accountNumber) {
        return accountRepository.findByAccountNumber(accountNumber);
    }

    public List<AccountDetails> fetchAllAccounts() {
        return accountRepository.findAll();
    }

    public void addAccount(AccountDetails accountDetails) {
        accountRepository.save(accountDetails);
    }

    public void deleteAccount(String accountId) {
        accountRepository.deleteById(accountId);
    }

    public void updateAccountDetails(AccountDetails accountDetails) {
        accountRepository.save(accountDetails);
    }

    public List<AccountDetails> fetchAllAccOfUser(String userId) {
        return accountRepository.findByUserId(userId);
    }
}
