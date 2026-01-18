package com.example.mybank.dtos.requests;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class TransferRequest {
    private  Long id;
    private String fromAccountNumber;
    private String toAccountNumber;
    private double amount;
    private String password;
}
