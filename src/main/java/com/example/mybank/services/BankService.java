package com.example.mybank.services;

import com.example.mybank.dtos.requests.*;
import com.example.mybank.dtos.responses.*;


public interface BankService {
    DepositResponse deposit(DepositRequest request);
    CreateAccountResponse createAccount(CreateAccountRequest request);
    WithdrawResponse withdraw(WithdrawRequest request);
    TransferResponse transfer(TransferRequest request);
    TransferToAnotherBankResponse transferToAnotherBank(TransferToAnotherBankRequest request);
    ShowBalanceResponse showBalance(ShowBalanceRequest request);
}
