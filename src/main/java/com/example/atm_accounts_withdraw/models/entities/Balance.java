package com.example.atm_accounts_withdraw.models.entities;

import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;

import javax.persistence.*;

@Data
@FieldDefaults(level= AccessLevel.PRIVATE)
@Entity
@Table(name="balances")
public class Balance {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    double balance;
}
