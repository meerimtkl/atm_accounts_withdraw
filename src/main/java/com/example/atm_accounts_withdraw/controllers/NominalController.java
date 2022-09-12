package com.example.atm_accounts_withdraw.controllers;

import com.example.atm_accounts_withdraw.models.entities.Nominal;
import com.example.atm_accounts_withdraw.models.entities.Requests.RequestWithdraw;
import com.example.atm_accounts_withdraw.models.entities.Responses.ResponseWithdraw;
import com.example.atm_accounts_withdraw.services.NominalService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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
    public ResponseWithdraw withDrawMoney(@RequestBody RequestWithdraw requestWithdraw){
       return nominalService.withDraw(requestWithdraw.getAccount(), requestWithdraw.getAmount());
    }


    @ExceptionHandler(RuntimeException.class)
    public ResponseEntity<String> handleException(
            Exception exception
    ) {
        return ResponseEntity
                .status(HttpStatus.INTERNAL_SERVER_ERROR)
                .body(exception.getMessage());
    }



    }
