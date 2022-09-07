package com.example.atm_accounts_withdraw.controllers;

import com.example.atm_accounts_withdraw.models.entities.Client;
import com.example.atm_accounts_withdraw.models.entities.dtos.ClientInfoDto;
import com.example.atm_accounts_withdraw.services.AccountService;
import com.example.atm_accounts_withdraw.services.ClientService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("Api/v1/clients")
public class ClientController {
    private final ClientService clientService;
    private final AccountService accountService;

    public ClientController(ClientService clientService, AccountService accountService) {
        this.clientService = clientService;
        this.accountService = accountService;
    }

    @GetMapping("info")
    public ClientInfoDto getInformationById(@RequestParam Long clientId){
        return clientService.findAll(clientId);

    }
    @PostMapping("save")
    public Client save(@RequestBody Client client){
        return clientService.save(client);
    }


}
