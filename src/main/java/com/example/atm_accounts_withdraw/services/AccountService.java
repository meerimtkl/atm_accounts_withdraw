package com.example.atm_accounts_withdraw.services;

import com.example.atm_accounts_withdraw.models.entities.Account;
import com.example.atm_accounts_withdraw.models.entities.dtos.AccountDto;

import java.util.List;

public interface AccountService {
    Account save(Account account);
    List<Account> findByClient (Long id);
    Account findByAccount (String account);

}
