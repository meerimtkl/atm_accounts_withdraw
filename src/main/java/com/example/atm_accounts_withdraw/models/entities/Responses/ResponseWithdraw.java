package com.example.atm_accounts_withdraw.models.entities.Responses;

import com.example.atm_accounts_withdraw.models.entities.dtos.NominalDto;
import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;

import java.util.List;
@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
public class ResponseWithdraw {
         String account;
         double amount;
         double rest;
         List<NominalDto> nominals;

}
