package com.example.atm_accounts_withdraw.mappers.base;

import com.example.atm_accounts_withdraw.models.entities.Account;
import com.example.atm_accounts_withdraw.models.entities.Client;
import com.example.atm_accounts_withdraw.models.entities.dtos.AccountDto;
import com.example.atm_accounts_withdraw.models.entities.dtos.ClientDto;
import com.example.atm_accounts_withdraw.models.entities.dtos.ClientInfoDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;
@Mapper
public interface ClientMapper {
    ClientMapper INSTANCE = Mappers.getMapper(ClientMapper.class);

    @Mapping(source = "name", target = "name")

    ClientDto clientToClientDto(Client client);
}
