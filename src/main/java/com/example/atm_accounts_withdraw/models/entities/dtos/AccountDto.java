package com.example.atm_accounts_withdraw.models.entities.dtos;

import com.example.atm_accounts_withdraw.models.entities.Balance;
import com.example.atm_accounts_withdraw.models.entities.Client;
import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;

import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Data
@FieldDefaults(level= AccessLevel.PRIVATE)
public class AccountDto {

    String account;
    double balance;


}
