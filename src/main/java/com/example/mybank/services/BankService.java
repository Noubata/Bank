package com.example.mybank.services;

import com.example.mybank.dtos.requests.CreateAccountRequest;
import com.example.mybank.dtos.requests.DepositRequest;
import com.example.mybank.dtos.requests.TransferRequest;
import com.example.mybank.dtos.requests.WithdrawRequest;
import com.example.mybank.dtos.responses.CreateAccountResponse;
import com.example.mybank.dtos.responses.DepositResponse;
import com.example.mybank.dtos.responses.TransferResponse;
import com.example.mybank.dtos.responses.WithdrawResponse;


public interface BankService {
    DepositResponse deposit(DepositRequest request);
    CreateAccountResponse createAccount(CreateAccountRequest request);
    WithdrawResponse withdraw(WithdrawRequest request);
    TransferResponse transfer(TransferRequest request);
}
