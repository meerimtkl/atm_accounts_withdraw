package com.example.atm_accounts_withdraw.services.impl;

import com.example.atm_accounts_withdraw.mappers.base.AccountMapper;
import com.example.atm_accounts_withdraw.mappers.base.ClientMapper;
import com.example.atm_accounts_withdraw.models.entities.Account;
import com.example.atm_accounts_withdraw.models.entities.Client;
import com.example.atm_accounts_withdraw.models.entities.dtos.AccountDto;
import com.example.atm_accounts_withdraw.models.entities.dtos.ClientDto;
import com.example.atm_accounts_withdraw.models.entities.dtos.ClientInfoDto;
import com.example.atm_accounts_withdraw.repo.AccountRepo;
import com.example.atm_accounts_withdraw.repo.BalanceRepo;
import com.example.atm_accounts_withdraw.repo.ClientRepo;
import com.example.atm_accounts_withdraw.services.AccountService;
import com.example.atm_accounts_withdraw.services.ClientService;
import org.springframework.stereotype.Service;
import java.util.List;
@Service
public class ClientServiceImpl implements ClientService {

 private final ClientRepo clientRepo;
 private  final AccountRepo accountRepo;
 private final BalanceRepo balanceRepo;
 private  final AccountService accountService;
 private final ClientMapper clientMapper;
 private final AccountMapper accountMapper;



    public ClientServiceImpl(ClientRepo clientRepo, AccountRepo accountRepo, BalanceRepo balanceRepo, AccountService accountService) {
        this.clientRepo = clientRepo;
        this.accountRepo = accountRepo;
        this.balanceRepo = balanceRepo;
        this.accountService = accountService;
        this.clientMapper = ClientMapper.INSTANCE;
        this.accountMapper = AccountMapper.INSTANCE;
    }

    @Override
    public Client save(Client client) {
        return clientRepo.save(client);
    }

    @Override
    public ClientInfoDto findAll(Long clientId) {
        //    List<Account> accountList = accountRepo.findAll();
     //  List<Client> clientList=clientRepo.findAll();
        Client client=clientRepo.findById(clientId).orElseThrow();
     List<Account> accountList=accountService.findByClient(clientId);
ClientDto clientDto=clientMapper.clientToClientDto(client);
List<AccountDto> accountDtos=accountMapper.toDtos(accountList);

        ClientInfoDto clientInfoDto=new ClientInfoDto();
        clientInfoDto.setClientDto(clientDto);
        clientInfoDto.setAccountDtos(accountDtos);

    return clientInfoDto;
    }

}
