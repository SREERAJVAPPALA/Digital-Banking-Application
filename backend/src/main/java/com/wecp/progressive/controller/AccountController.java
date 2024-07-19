package com.wecp.progressive.controller;

import com.wecp.progressive.entity.Accounts;
import com.wecp.progressive.service.AccountService;
import com.wecp.progressive.service.AccountServiceImplJpa;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
public class AccountController {
    @Autowired
    private AccountServiceImplJpa accountServiceImplJpa;

    @GetMapping("/accounts")
    public ResponseEntity<List<Accounts>> getAllAccounts() {
        return new ResponseEntity<>(accountServiceImplJpa.getAllAccounts(),HttpStatus.OK);
    }

    public ResponseEntity<Accounts> getAccountById(int accountId) {
        return new ResponseEntity<Accounts>(accountServiceImplJpa.getAccountById(accountId), HttpStatus.OK);
    }

    public ResponseEntity<List<Accounts>> getAccountsByUser(String param) {
        return null;
    }

    public ResponseEntity<Integer> addAccount(Accounts accounts) {
        return new ResponseEntity<>(accountServiceImplJpa.addAccount(accounts),HttpStatus.OK);
    }

    public ResponseEntity<Void> updateAccount(int accountId, Accounts accounts) {
        accountServiceImplJpa.updateAccount(accountId, accounts);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    public ResponseEntity<Void> deleteAccount(int accountId) {
        accountServiceImplJpa.deleteAccount(accountId);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}