package com.iitp.projects.financemanager.controller;

import com.iitp.projects.financemanager.model.TransactionDetails;
import com.iitp.projects.financemanager.service.TransactionService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class TransactionController {

    TransactionService transactionService;

    public TransactionController(TransactionService transactionService) {
        this.transactionService = transactionService;
    }

    @GetMapping("/fetchAllTransactions")
    public ResponseEntity<List<TransactionDetails>> fetchAllTransactions() {
        return new ResponseEntity<>(transactionService.fetchAllTransactions(), HttpStatus.OK);
    }

    @GetMapping("/fetchTransactionsByUser/{userId}")
    public ResponseEntity<List<TransactionDetails>> fetchTransactionsByUser(@PathVariable String userId) throws Exception {
        return new ResponseEntity<>(transactionService.fetchTransactionsByUserId(userId), HttpStatus.OK);
    }

    @PostMapping("/addTransaction")
    public ResponseEntity<String> addTransaction(@RequestBody TransactionDetails transactionDetails) {
        transactionService.addTransaction(transactionDetails);
        return new ResponseEntity<>("Success", HttpStatus.OK);
    }

}
