package com.example.mybank.utils;

import com.example.mybank.data.models.Account;
import com.example.mybank.dtos.responses.*;
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
        return new TransferResponse(
        fromAccountBalance,
        toAccountBalance,
        "Transfer successful"
        );
    }
    public static TransferToAnotherBankResponse toTransferToAnotherBankResponse(double fromBalance, double toBalance) {
        return new TransferToAnotherBankResponse(
                fromBalance,
                toBalance,
                "Transfer to another bank successful"
        );
    }

    public static ShowBalanceResponse toShowBalanceResponse(String accountNumber, double balance) {
        return new ShowBalanceResponse(
                accountNumber,
                balance
        );
    }
}