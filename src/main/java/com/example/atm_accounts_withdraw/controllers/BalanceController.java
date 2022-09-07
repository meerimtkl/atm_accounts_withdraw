package com.example.atm_accounts_withdraw.controllers;

import com.example.atm_accounts_withdraw.models.entities.Balance;
import com.example.atm_accounts_withdraw.services.BalanceService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("Api/v1/balances")
public class BalanceController {
    private final BalanceService balanceService;

    public BalanceController(BalanceService balanceService) {
        this.balanceService = balanceService;
    }
    @PostMapping("save")
    public Balance save(@RequestBody Balance balance){
        return balanceService.save(balance);

    }
}
