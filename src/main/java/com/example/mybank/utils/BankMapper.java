package com.example.mybank.utils;

import com.example.mybank.data.models.Account;
import com.example.mybank.dtos.responses.CreateAccountResponse;
import com.example.mybank.dtos.responses.DepositResponse;
import com.example.mybank.dtos.responses.TransferResponse;
import com.example.mybank.dtos.responses.WithdrawResponse;
import org.springframework.stereotype.Component;

@Component
public class BankMapper {

    public static DepositResponse toDepositResponse(Account account) {
        return new DepositResponse(
                account.getBalance(),
                "Deposit successful"
        );
    }

    public static CreateAccountResponse toCreateAccountResponse(Account account) {
        return new CreateAccountResponse(
                account.getAccountNumber(),
                "thanks for banking with us, account number is" + account.getAccountNumber(),
                account.getBalance()
        );
    }

    public static WithdrawResponse toWithdrawResponse(Account account) {
        return new WithdrawResponse(
                account.getBalance(),
                "withdraw successful"
        );
    }

    public static TransferResponse toTransferResponse(double fromAccountBalance, double toAccountBalance) {
        TransferResponse response = new TransferResponse();
        response.setBalance(fromAccountBalance);
        response.setBalance(toAccountBalance);
        response.setMessage("Transfer successful");
        return response;
    }
}

