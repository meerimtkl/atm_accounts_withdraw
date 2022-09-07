package com.example.atm_accounts_withdraw.services.impl;

import com.example.atm_accounts_withdraw.models.entities.Balance;
import com.example.atm_accounts_withdraw.repo.BalanceRepo;
import com.example.atm_accounts_withdraw.services.BalanceService;
import org.springframework.stereotype.Service;

@Service
public class BalanceServiceImpl implements BalanceService {
    private  final BalanceRepo balanceRepo;

    public BalanceServiceImpl(BalanceRepo balanceRepo) {
        this.balanceRepo = balanceRepo;
    }

    @Override
    public Balance save(Balance balance) {
        return balanceRepo.save(balance);
    }
}
