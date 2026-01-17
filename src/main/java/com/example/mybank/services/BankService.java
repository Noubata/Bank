package com.example.mybank.services;

import com.example.mybank.dtos.requests.DepositRequest;
import com.example.mybank.dtos.responses.DepositResponse;


public interface BankService {
    DepositResponse deposit(DepositRequest request);
}
