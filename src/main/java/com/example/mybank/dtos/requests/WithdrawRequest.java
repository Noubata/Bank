package com.example.mybank.dtos.requests;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class WithdrawRequest {
    private Long id;
    private String accountNumber;
    private double amount;
    private String password;
}
