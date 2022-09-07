package com.example.atm_accounts_withdraw.repo;

import com.example.atm_accounts_withdraw.models.entities.Account;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface AccountRepo extends JpaRepository<Account,Long> {
 // Account findAllById(Long id);
    List <Account> findAllByClientId(Long id);
}
