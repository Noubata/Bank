package com.example.mybank.services;

import com.example.mybank.data.models.Account;
import com.example.mybank.data.models.Bank;
import com.example.mybank.data.repositories.AccountNumberGeneratorRepository;
import com.example.mybank.data.repositories.AccountRepository;
import com.example.mybank.data.repositories.BankRepository;
import com.example.mybank.dtos.requests.CreateAccountRequest;
import com.example.mybank.dtos.requests.DepositRequest;
import com.example.mybank.dtos.requests.TransferRequest;
import com.example.mybank.dtos.requests.WithdrawRequest;
import com.example.mybank.dtos.responses.CreateAccountResponse;
import com.example.mybank.dtos.responses.DepositResponse;
import com.example.mybank.dtos.responses.TransferResponse;
import com.example.mybank.dtos.responses.WithdrawResponse;
import com.example.mybank.exceptions.AccountException;
import com.example.mybank.exceptions.BankException;
import com.example.mybank.exceptions.InsufficientFunds;
import com.example.mybank.utils.BankMapper;
import org.apache.catalina.mapper.Mapper;
import org.springframework.stereotype.Service;


@Service
public class BankServiceImplementation implements BankService {


    private final BankRepository bankRepository;

    private final AccountRepository accountRepository;
    private final AccountNumberGeneratorServiceImplementation generator;

    public BankServiceImplementation(BankRepository bankRepository, AccountRepository accountRepository, AccountNumberGeneratorServiceImplementation repository) {
        this.bankRepository = bankRepository;
        this.accountRepository = accountRepository;
        this.generator = repository;
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

    @Override
    public CreateAccountResponse createAccount (CreateAccountRequest request){
        Bank bank = bankRepository.findBankById(request.getId());
        if (bank == null) {
            throw new BankException("Bank not found");
        }
        String nuban = generator.generateAccountNumber(123);
        Account account = new Account();
        account.setUserName(request.getUserName());
        account.setPassword(request.getPassword());
        account.setBalance(0.0);
        accountRepository.save(account);
        return BankMapper.toCreateAccountResponse(account);
    }
    @Override
    public WithdrawResponse withdraw(WithdrawRequest request){
        Bank bank = bankRepository.findBankById(request.getId());
        if (bank == null) {
            throw new BankException("Bank not found");
        }
        Account account = validateAndGetAccount(bank, request.getAccountNumber());
        double newBalance = account.getBalance() - request.getAmount();
        account.setBalance(newBalance);
        accountRepository.save(account);
        return BankMapper.toWithdrawResponse(account);
    }
    @Override
    public TransferResponse transfer (TransferRequest request){
        Bank bank = bankRepository.findBankById(request.getId());
        if (bank == null) {
            throw new BankException("Bank not found");
        }
        Account fromAccount = validateAndGetAccount(bank, request.getFromAccountNumber());
        Account toAccount = validateAndGetAccount(bank, request.getToAccountNumber());

        if (fromAccount.getBalance() < request.getAmount()) {
            throw new InsufficientFunds("Insufficient funds in the source account");
        }
        fromAccount.setBalance(fromAccount.getBalance() - request.getAmount());
        toAccount.setBalance(toAccount.getBalance() - request.getAmount());
        accountRepository.save(fromAccount);
        accountRepository.save(toAccount);
        return BankMapper.toTransferResponse(fromAccount.getBalance(), toAccount.getBalance());
    }
}