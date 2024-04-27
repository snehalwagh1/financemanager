package com.iitp.projects.financemanager.service;

import com.iitp.projects.financemanager.model.TransactionDetails;
import com.iitp.projects.financemanager.repository.TransactionRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TransactionService {

    TransactionRepository transactionRepository;

    public TransactionService(TransactionRepository transactionRepository) {
        this.transactionRepository = transactionRepository;
    }

    public void addTransaction(TransactionDetails transactionDetails) {
        transactionRepository.save(transactionDetails);
    }

    public List<TransactionDetails> fetchTransactionsByUserId(String userId) {
        return transactionRepository.findAllByUserId(List.of(userId));
    }

    public List<TransactionDetails> fetchAllTransactions() {
        return transactionRepository.findAll();
    }
}
