package com.example.atm_accounts_withdraw.services.impl;

import com.example.atm_accounts_withdraw.models.entities.Account;
import com.example.atm_accounts_withdraw.models.entities.Balance;
import com.example.atm_accounts_withdraw.models.entities.Nominal;
import com.example.atm_accounts_withdraw.models.entities.Responses.ResponseWithdraw;
import com.example.atm_accounts_withdraw.models.entities.dtos.NominalDto;
import com.example.atm_accounts_withdraw.repo.NominalRepo;
import com.example.atm_accounts_withdraw.services.AccountService;
import com.example.atm_accounts_withdraw.services.BalanceService;
import com.example.atm_accounts_withdraw.services.NominalService;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

@Service
public class NominalServiceImpl implements NominalService {
    private final NominalRepo nominalRepo;
    private final AccountService accountService;
    private final BalanceService balanceService;

    public NominalServiceImpl(NominalRepo nominalRepo, AccountService accountService, BalanceService balanceService) {
        this.nominalRepo = nominalRepo;
        this.accountService = accountService;
        this.balanceService = balanceService;
    }

    @Override
    public Nominal save(Nominal nominal) {
        return nominalRepo.save(nominal);
    }

    private List<NominalDto> getNominals(double amount) {

        double amountToWithdraw = amount;
        List<NominalDto> result = new ArrayList<>();

        List<Nominal> nominals = nominalRepo // получаем только существуюшие банкноты
                .findAllNominalByNominalLessThanEqualAndAmountGreaterThanOrderByNominalDesc(amount, 0);
        for (Nominal nominal : nominals) {
            if (amount >= nominal.getNominal()) {
                NominalDto nominalDto = new NominalDto();
                nominalDto.setNominal(nominal.getNominal());
                int nominalCountToWithdraw = (int) Math.floor(amount / nominal.getNominal());  // берем низкую инт
                if (nominal.getAmount() < nominalCountToWithdraw){ // если нет кол-во банкнот в базе, берем сколько есть
                    nominalCountToWithdraw = nominal.getAmount();
                }
                nominalDto.setAmount(nominalCountToWithdraw);

                // уменьшаем кол-во банкнот в базе
                nominal.setAmount(nominal.getAmount() - nominalCountToWithdraw);
                nominalRepo.save(nominal);

                result.add(nominalDto);

                amount = amount - nominal.getNominal() * nominalCountToWithdraw;
            }
        }
        if (amount > 0){
            throw new RuntimeException("No cash nominal for amount " + amountToWithdraw);
        }
        return result;


    }
    @Transactional
    @Override
    public ResponseWithdraw withDraw(String account, double amount) {
        Account accountObj = accountService.findByAccount(account);
        Balance balance = accountObj.getBalance();
        if (balance.getBalance() < amount) {
            throw new RuntimeException("Insufficient amount in account "
                    + account + ", balance: " + balance.getBalance());
        }

        balance.setBalance(balance.getBalance() - amount);
        balanceService.save(balance);

        ResponseWithdraw withdrawResult = new ResponseWithdraw();
        withdrawResult.setAccount(account);
        withdrawResult.setAmount(amount);
        withdrawResult.setRest(balance.getBalance());
        withdrawResult.setNominals(getNominals(amount));


//List<Double>nominals=new ArrayList<>();
//        List<Nominal> naminals = new ArrayList<>();
//
//        for (long i = 1; i < 9; i++) {
//            Nominal nam = new Nominal();
//
//            nam.setAmount();
//            if (amount >=nominalRepo.findNominalById(i)) {
//           int amountOfMoney=(amount / nominalRepo.findNominalById(i));
//                nam.setAmount(amountOfMoney);
//                amount = amount % nominalRepo.findNominalById(i));
//            }
//
//        }
//
        return withdrawResult;
    }

}

