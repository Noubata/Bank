package com.example.mybank.data.repositories;

import com.example.mybank.data.models.AccountNumberGenerator;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface AccountNumberGeneratorRepository extends JpaRepository<AccountNumberGenerator, Long> {
    @Query(value = "SELECT nextval('account_number_seq')", nativeQuery = true)
    Long getNextSerial();
}
