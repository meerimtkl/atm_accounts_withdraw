package com.example.atm_accounts_withdraw.controllers;

import com.example.atm_accounts_withdraw.models.entities.Account;
import com.example.atm_accounts_withdraw.services.AccountService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("Api/v1/accounts")
public class AccountController {
    private final AccountService accountService;

    public AccountController(AccountService accountService) {
        this.accountService = accountService;
    }

    @PostMapping("save")
    public Account save(@RequestBody Account account){
        return accountService.save(account);
    }
}
