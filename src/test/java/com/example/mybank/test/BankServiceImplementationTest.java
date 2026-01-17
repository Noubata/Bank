package com.example.mybank.test;

import com.example.mybank.data.models.Account;
import com.example.mybank.data.models.Bank;
import com.example.mybank.data.repositories.AccountRepository;
import com.example.mybank.data.repositories.BankRepository;
import com.example.mybank.dtos.requests.DepositRequest;
import com.example.mybank.dtos.responses.DepositResponse;
import com.example.mybank.services.BankService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;


import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@SpringBootTest
class BankServiceImplementationTest {

    @Autowired
    BankService bankService;
    @MockBean
    BankRepository  bankRepository;
    @MockBean
    AccountRepository accountRepository;
    Bank bank;
    Account account;

    @BeforeEach
    void setUp() {
        //bankServiceImplementation  = new BankServiceImplementation();
        bank = new Bank();
        account = new Account();
    }
    @Test
    void testThat_CreateBankAccount_Add500_BalanceIs500() {
        account.setBalance(500);
        account.setAccountNumber("1234567890");
        account.setPassword("12345");
        account.setUserName("Benny");
        account.setId(1L);
        bank.setAccounts(List.of(account));
        bank.setId(1L);
        bank.setBankName("testBank");
        DepositRequest  depositRequest = new DepositRequest();
        depositRequest.setBankId(1L);
        depositRequest.setAmount(500);
        depositRequest.setAccountNumber("1234567890");

        when(bankRepository.findBankById(1L)).thenReturn(bank);
        when(accountRepository.save(account)).thenReturn(account);

        DepositResponse response = bankService.deposit(depositRequest);
        assertEquals(500.0, response.getNewBalance());
        assertEquals("amount successfully added", response.getMessage());
    }
}