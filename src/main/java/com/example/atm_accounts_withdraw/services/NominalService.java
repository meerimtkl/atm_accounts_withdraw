package com.example.atm_accounts_withdraw.services;

import com.example.atm_accounts_withdraw.models.entities.Nominal;
import com.example.atm_accounts_withdraw.models.entities.Responses.ResponseWithdraw;

public interface NominalService {
    Nominal save(Nominal nominal);
    public ResponseWithdraw withDraw(String account, double amount);

}
