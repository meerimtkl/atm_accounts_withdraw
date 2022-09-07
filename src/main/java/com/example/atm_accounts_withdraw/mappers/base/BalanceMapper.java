package com.example.atm_accounts_withdraw.mappers.base;

import com.example.atm_accounts_withdraw.models.entities.Balance;
import com.example.atm_accounts_withdraw.models.entities.Client;
import com.example.atm_accounts_withdraw.models.entities.dtos.BalanceDto;
import com.example.atm_accounts_withdraw.models.entities.dtos.ClientDto;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

public interface BalanceMapper {
    BalanceMapper INSTANCE = Mappers.getMapper(BalanceMapper.class);

    @Mapping(source = "balance.balance", target = "balance")
    BalanceDto balanceToBalanceDto(Balance balance);
}
