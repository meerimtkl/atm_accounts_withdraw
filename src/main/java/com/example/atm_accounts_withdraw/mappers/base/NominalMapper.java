package com.example.atm_accounts_withdraw.mappers.base;

import com.example.atm_accounts_withdraw.models.entities.Client;
import com.example.atm_accounts_withdraw.models.entities.Nominal;
import com.example.atm_accounts_withdraw.models.entities.dtos.ClientDto;
import com.example.atm_accounts_withdraw.models.entities.dtos.NominalDto;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

public interface NominalMapper {
    NominalMapper INSTANCE = Mappers.getMapper(NominalMapper.class);

    @Mapping(source = "nominal", target = "nominal")
    @Mapping(source = "amount", target = "amount")
    NominalDto nominalToDto(Nominal nominal);
}
