package com.example.atm_accounts_withdraw.models.entities.dtos;

import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;

@Data
@FieldDefaults(level= AccessLevel.PRIVATE)
public class BalanceDto {

    double balance;
}
