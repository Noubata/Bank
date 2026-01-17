package com.example.mybank.services;

import com.example.mybank.data.models.Account;
import com.example.mybank.data.models.Bank;
import com.example.mybank.data.repositories.AccountRepository;
import com.example.mybank.data.repositories.BankRepository;
import com.example.mybank.dtos.requests.DepositRequest;
import com.example.mybank.dtos.responses.DepositResponse;
import com.example.mybank.exceptions.AccountException;
import com.example.mybank.exceptions.BankException;
import com.example.mybank.utils.BankMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BankServiceImplementation implements BankService {

    private final BankRepository bankRepository;

    private final AccountRepository accountRepository;

    public BankServiceImplementation(BankRepository bankRepository,
                                     AccountRepository accountRepository) {
        this.bankRepository = bankRepository;
        this.accountRepository = accountRepository;
    }
    private Account validateAndGetAccount(Bank bank, String accountNumber) {
        for (Account account : bank.getAccounts()) {
            if (account.getAccountNumber().equals(accountNumber)) {
                return account;
            }
        }
        throw new AccountException("Account not found");
    }
    @Override
    public DepositResponse deposit(DepositRequest request) {
        Bank bank = bankRepository.findBankById(request.getBankId());
        if (bank == null) {
            throw new BankException("Bank not found");
        }
        Account account = validateAndGetAccount(bank, request.getAccountNumber());
        double newBalance = account.getBalance() + request.getAmount();
        account.setBalance(newBalance);
        accountRepository.save(account);
        return BankMapper.toDepositResponse(account);
    }


}