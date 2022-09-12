package com.example.atm_accounts_withdraw.services.impl;

import com.example.atm_accounts_withdraw.models.entities.Account;
import com.example.atm_accounts_withdraw.models.entities.dtos.AccountDto;
import com.example.atm_accounts_withdraw.repo.AccountRepo;
import com.example.atm_accounts_withdraw.services.AccountService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AccountServiceImpl implements AccountService {
//Найти клиента
//Список всех акаунтов
    private final AccountRepo accountRepo;

    public AccountServiceImpl(AccountRepo accountRepo) {
        this.accountRepo = accountRepo;
    }

    @Override
    public Account save(Account account) {
        return accountRepo.save(account);
    }

    @Override
    public List<Account> findByClient(Long id) {

        return accountRepo.findAllByClientId(id);
    }

    @Override
    public Account findByAccount(String account) {

        return accountRepo.findByAccount(account);
    }



}
