package com.example.atm_accounts_withdraw.services;

import com.example.atm_accounts_withdraw.models.entities.Account;
import com.example.atm_accounts_withdraw.models.entities.Nominal;
import java.util.List;

public interface NominalService {
    Nominal save(Nominal nominal);
    public List<Double> withDraw(String account, double amount);

}
