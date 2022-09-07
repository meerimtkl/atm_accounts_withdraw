package com.example.atm_accounts_withdraw.models.entities.dtos;
import com.example.atm_accounts_withdraw.models.entities.Account;
import com.example.atm_accounts_withdraw.models.entities.Client;
import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;

import java.util.List;
@Data
@FieldDefaults(level= AccessLevel.PRIVATE)
public class ClientInfoDto {
    ClientDto clientDto;
    List<AccountDto>accountDtos;

    //ClientDto
 //   List<AccountDto>
}
