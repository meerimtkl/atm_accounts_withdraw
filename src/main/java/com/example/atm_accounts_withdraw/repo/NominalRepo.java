package com.example.atm_accounts_withdraw.repo;

import com.example.atm_accounts_withdraw.models.entities.Nominal;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface NominalRepo extends JpaRepository<Nominal,Long> {
double findNominalById(Long id);
}
