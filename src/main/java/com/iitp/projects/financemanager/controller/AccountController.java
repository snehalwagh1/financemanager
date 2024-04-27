package com.iitp.projects.financemanager.controller;

import com.iitp.projects.financemanager.model.AccountDetails;
import com.iitp.projects.financemanager.service.AccountDetailsService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/account")
public class AccountController {

    AccountDetailsService accountService;

    public AccountController(AccountDetailsService accountService) {
        this.accountService = accountService;
    }

    @GetMapping("/getAccountDetails/{accountNumber}")
    public ResponseEntity<AccountDetails> getAccountDetails(@RequestParam String accountNumber) {
        return new ResponseEntity<>(accountService.getAccDetailsByAccNum(accountNumber), HttpStatus.OK);
    }

    @GetMapping("/fetchAllAccounts")
    public ResponseEntity<List<AccountDetails>> fetchAllAccountDetails() {
        return new ResponseEntity<>(accountService.fetchAllAccounts(), HttpStatus.OK);
    }

    @GetMapping("/fetchAllAccOfUser/{userId}")
    public ResponseEntity<List<AccountDetails>> fetchAllAccOfUser(@PathVariable String userId) {
        return new ResponseEntity<>(accountService.fetchAllAccOfUser(userId), HttpStatus.OK);
    }

    @PostMapping("/addUserAccount")
    public ResponseEntity<String> addAccount(@RequestBody AccountDetails accountDetails) {
        accountService.addAccount(accountDetails);
        return new ResponseEntity<>("Success", HttpStatus.OK);
    }

    @GetMapping("/deleteAccount/{accountId}")
    public ResponseEntity<String> deleteAccount(@PathVariable String accountId) {
        accountService.deleteAccount(accountId);
        return new ResponseEntity<>("Success", HttpStatus.OK);
    }

    @PostMapping("/updateAccountDetails")
    public ResponseEntity<String> updateAccountDetails(@RequestBody AccountDetails accountDetails) {
        accountService.updateAccountDetails(accountDetails);
        return new ResponseEntity<>("Success", HttpStatus.OK);
    }

}
