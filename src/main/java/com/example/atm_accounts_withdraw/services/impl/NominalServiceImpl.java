package com.example.atm_accounts_withdraw.services.impl;

import com.example.atm_accounts_withdraw.models.entities.Account;
import com.example.atm_accounts_withdraw.models.entities.Nominal;
import com.example.atm_accounts_withdraw.repo.NominalRepo;
import com.example.atm_accounts_withdraw.services.NominalService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class NominalServiceImpl implements NominalService {
    private final NominalRepo nominalRepo;

    public NominalServiceImpl(NominalRepo nominalRepo) {
        this.nominalRepo = nominalRepo;
    }

    @Override
    public Nominal save(Nominal nominal) {
        return nominalRepo.save(nominal);
    }

    @Override
    public List<Nominal> withDraw( double amount) {

List<Double>nominals=new ArrayList<>();
        List<Nominal> naminals = new ArrayList<>();

        for (long i = 1; i < 9; i++) {
            Nominal nam = new Nominal();

            nam.setAmount();
            if (amount >=nominalRepo.findNominalById(i)) {
           int amountOfMoney=(amount / nominalRepo.findNominalById(i));
                nam.setAmount(amountOfMoney);
                amount = amount % nominalRepo.findNominalById(i));
            }

        }

        return nominals;
    }

}

