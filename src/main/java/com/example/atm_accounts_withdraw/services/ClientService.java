package com.example.atm_accounts_withdraw.services;

import com.example.atm_accounts_withdraw.models.entities.Client;
import com.example.atm_accounts_withdraw.models.entities.dtos.ClientInfoDto;

public interface ClientService {
 Client save(Client client);

 ClientInfoDto findAll(Long clientId);

}
