package com.example.mybank.dtos.requests;

import com.example.mybank.data.repositories.AccountRepository;
import com.example.mybank.data.repositories.BankRepository;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class TransferToAnotherBankRequest {
    private long id;
//    private BankRepository bankRepository;
//    private AccountRepository accountRepository;
    private String fromAccountNumber;
    private String toAccountNumber;
    private double amount;
    private String password;
}
