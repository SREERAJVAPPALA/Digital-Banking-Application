package com.wecp.progressive.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wecp.progressive.entity.Accounts;
import com.wecp.progressive.repository.AccountRepository;
import com.wecp.progressive.repository.CustomerRepository;

@Service
public class AccountServiceImplJpa {
    @Autowired
    private AccountRepository accountRepository;

    public List<Accounts> getAllAccounts(){
        return accountRepository.findAll();
    }

    public Accounts getAccountById(int accountId){
        return accountRepository.findById(accountId).get();
    }

    public Integer  addAccount(Accounts accounts){
        accountRepository.save(accounts);
        return accounts.getAccountId();
    }

    public void updateAccount(int accountId, Accounts accounts){
        accountRepository.save(accounts);
    }

    public void deleteAccount(int accountId){
        accountRepository.deleteById(accountId);
    }
    
}