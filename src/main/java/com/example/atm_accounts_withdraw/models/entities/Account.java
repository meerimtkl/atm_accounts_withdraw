package com.example.atm_accounts_withdraw.models.entities;

import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;

import javax.persistence.*;

@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
@Entity
@Table(name = "accounts")
public class Account {
    @Id
            @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    String account;
    @ManyToOne
    @JoinColumn(name="balance_id")
    Balance balance;
    @ManyToOne
    @JoinColumn(name="client_id")
    Client client;


}
