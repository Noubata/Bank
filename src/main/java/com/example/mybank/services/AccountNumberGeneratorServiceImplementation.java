package com.example.mybank.services;

import com.example.mybank.data.repositories.AccountNumberGeneratorRepository;
import org.springframework.stereotype.Service;

@Service
public class AccountNumberGeneratorServiceImplementation implements AccountNumberGeneratorService {

    private final AccountNumberGeneratorRepository repository;

    public AccountNumberGeneratorServiceImplementation(AccountNumberGeneratorRepository repository) {
        this.repository = repository;
    }

    @Override
    public String generateAccountNumber(int bankCode) {
        long serialNumber = repository.getNextSerial();
        String eachSerial = String.format("%09d", serialNumber);
        return generateNUBAN(bankCode, eachSerial);
    }
    private String generateNUBAN(int bankCode, String eachSerial) {
        int checkDigit = calculateCheckDigit(bankCode, eachSerial);
        return eachSerial + checkDigit;
    }
    private int calculateCheckDigit(int bankCode, String eachSerial) {
        String accountBase = bankCode + eachSerial;
        int[] fixedNumber = {3,7,3,3,7,3,3,7,3,3,7,3};
        int sumOfCalculatedDigit = 0;
        for (int count = 0; count < fixedNumber.length;count++) {
            int digit = Character.getNumericValue(accountBase.charAt(count));
            sumOfCalculatedDigit += digit * fixedNumber[count];
        }
        int checkDigit = 10 - (sumOfCalculatedDigit % 10);
        return checkDigit;
    }
}
