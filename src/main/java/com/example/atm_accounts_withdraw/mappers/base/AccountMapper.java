package com.example.atm_accounts_withdraw.mappers.base;

import com.example.atm_accounts_withdraw.models.entities.Account;
import com.example.atm_accounts_withdraw.models.entities.Client;
import com.example.atm_accounts_withdraw.models.entities.dtos.AccountDto;
import com.example.atm_accounts_withdraw.models.entities.dtos.ClientInfoDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import javax.persistence.MappedSuperclass;
import java.util.List;

@Mapper

public interface AccountMapper {
    AccountMapper INSTANCE = Mappers.getMapper(AccountMapper.class);

    @Mapping(source = "balance.balance", target = "balance")
    AccountDto accountToAccountDto(Account account);
    @Mapping(source = "balance.balance", target = "balance")
    List<AccountDto> toDtos(List<Account> accountList);
}
