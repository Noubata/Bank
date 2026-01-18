package com.example.mybank.dtos.responses;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class TransferToAnotherBankResponse {
    private double senderBalance;
    private double receiverBalance;
    private String message;
}
