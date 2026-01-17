package com.example.mybank.data.repositories;

import com.example.mybank.data.models.Bank;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BankRepository extends JpaRepository<Bank, Long> {
    Bank findBankById(long id);
}
