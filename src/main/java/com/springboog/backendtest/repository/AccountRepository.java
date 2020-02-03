package com.springboog.backendtest.repository;

import com.springboog.backendtest.domain.Account;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface AccountRepository extends JpaRepository<Account, Integer>, JpaSpecificationExecutor<Account> {

    @Query("select a from Account a where a.username = ?1 and a.disabled = 0")
    Optional<Account> findOneByUsernameAndIsEnabled(String userName);
}
