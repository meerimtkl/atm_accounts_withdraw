package com.example.atm_accounts_withdraw.models.entities.Requests;

import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;

@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
public class RequestWithdraw {
    String account;
    double amount;
}
