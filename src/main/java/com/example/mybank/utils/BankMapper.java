package com.example.mybank.utils;

import com.example.mybank.data.models.Account;
import com.example.mybank.dtos.responses.DepositResponse;
import org.springframework.stereotype.Component;

@Component
public class BankMapper {

    public static DepositResponse toDepositResponse(Account account) {
        return new DepositResponse(
                account.getBalance(),
                "Deposit successful"
        );
    }
}

