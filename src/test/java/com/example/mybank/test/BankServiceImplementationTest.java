//package com.example.mybank.test;
//
//import com.example.mybank.data.models.Account;
//import com.example.mybank.data.models.Bank;
//import com.example.mybank.data.repositories.AccountRepository;
//import com.example.mybank.data.repositories.BankRepository;
//import com.example.mybank.dtos.requests.DepositRequest;
//import com.example.mybank.dtos.responses.DepositResponse;
//import com.example.mybank.services.BankService;
//import jakarta.transaction.Transactional;
//import org.junit.jupiter.api.BeforeEach;
//import org.junit.jupiter.api.Test;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.context.SpringBootTest;
//
//
//import java.util.List;
//
//import static org.junit.jupiter.api.Assertions.*;
//
//@SpringBootTest
//@Transactional
//class BankServiceImplementationTest {
//
//    @Autowired
//    private BankService bankService;
//    @Autowired
//    private BankRepository  bankRepository;
//    @Autowired
//    private AccountRepository accountRepository;
//    private Bank bank;
//    private Account account;
//
//    @BeforeEach
//    void setUp() {
//
//        bank = new Bank();
//        bank.setBankName("testBank");
//        bank =  bankRepository.save(bank);
//
//        account = new Account();
//        account.setBalance(0);
//        account.setAccountNumber("1234567890");
//        account.setPassword("12345");
//        account.setUserName("Benny");
//        account = accountRepository.save(account);
//
//        bank.setAccounts(List.of(account));
//        bankRepository.save(bank);
//    }
//    @Test
//    void testThat_CreateBankAccount_Add500_BalanceIs500() {
//
//        DepositRequest  depositRequest = new DepositRequest();
//        depositRequest.setBankId(bank.getId());
//        depositRequest.setAmount(500);
//        depositRequest.setAccountNumber("1234567890");
//
//        DepositResponse response = bankService.deposit(depositRequest);
//        assertEquals(500.0, response.getNewBalance());
//        assertEquals("amount successfully added", response.getMessage());
//    }
//}