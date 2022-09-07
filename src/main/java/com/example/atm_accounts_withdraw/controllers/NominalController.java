package com.example.atm_accounts_withdraw.controllers;

import com.example.atm_accounts_withdraw.models.entities.Account;
import com.example.atm_accounts_withdraw.models.entities.Nominal;
import com.example.atm_accounts_withdraw.services.NominalService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("Api/v1/account")
public class NominalController {

    private final NominalService nominalService;

    public NominalController(NominalService nominalService) {
        this.nominalService = nominalService;
    }

    @PostMapping("nominal/save")
    public Nominal save(@RequestBody Nominal nominal){
     return nominalService.save(nominal);

    }
    @PostMapping("withdrawal")
    public List<Double> withDrawMoney(@RequestParam String account, @RequestParam double amount){
       return nominalService.withDraw(account,amount);
    }




    }
