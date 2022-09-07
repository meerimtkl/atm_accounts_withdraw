package com.example.atm_accounts_withdraw.repo;

import com.example.atm_accounts_withdraw.models.entities.Balance;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BalanceRepo extends JpaRepository<Balance,Long> {
}
