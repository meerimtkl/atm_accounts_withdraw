package com.example.atm_accounts_withdraw.repo;

import com.example.atm_accounts_withdraw.models.entities.Client;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClientRepo extends JpaRepository<Client,Long> {

    Client findAllById(Long clientId);

}
