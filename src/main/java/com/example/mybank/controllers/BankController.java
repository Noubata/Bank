package com.example.mybank.controllers;

import com.example.mybank.dtos.requests.*;
import com.example.mybank.dtos.responses.*;
import com.example.mybank.services.BankService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/bank")
public class BankController {
    @Autowired
    private BankService bankService;
    @PostMapping("/create-account")
    public CreateAccountResponse createAccount(@RequestBody CreateAccountRequest request){
        return bankService.createAccount(request);
    }
    @PutMapping("/deposit")
    public DepositResponse deposit(@RequestBody DepositRequest request){
        return bankService.deposit(request);
    }
    @PutMapping("/withdraw")
    public WithdrawResponse withdraw(@RequestBody WithdrawRequest request){
        return bankService.withdraw(request);
    }
    @PutMapping("/transfer")
    public TransferResponse transfer(@RequestBody TransferRequest request){
        return bankService.transfer(request);
    }
    @PutMapping("/transfer-to-another-bank")
    public TransferToAnotherBankResponse  transferToAnotherBank(@RequestBody TransferToAnotherBankRequest request){
        return bankService.transferToAnotherBank(request);
    }
    @GetMapping("/show-balance")
    public ShowBalanceResponse  showBalance(@RequestBody ShowBalanceRequest request){
        return bankService.showBalance(request);
    }
}
