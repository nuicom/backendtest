package com.springboog.backendtest.service;

import com.springboog.backendtest.domain.Account;
import com.springboog.backendtest.repository.AccountRepository;
import com.springboog.backendtest.security.CustomerUserDetails;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;


@Service
public class CustomerDetailsService implements org.springframework.security.core.userdetails.UserDetailsService {

    private static final Logger log = LoggerFactory.getLogger(CustomerDetailsService.class);

    @Autowired
    private AccountRepository accountRepository;

    @Override
    public UserDetails loadUserByUsername(String username) {
        Optional<Account> account = accountRepository.findOneByUsernameAndIsEnabled(username);

        if (!account.isPresent()) {
            throw new UsernameNotFoundException("User " + username + " was not found in the database");
        }
        return new CustomerUserDetails(account.get());
    }
}
