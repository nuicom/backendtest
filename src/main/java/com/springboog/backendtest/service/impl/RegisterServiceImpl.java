package com.springboog.backendtest.service.impl;

import com.springboog.backendtest.domain.Account;
import com.springboog.backendtest.dto.AccountDto;
import com.springboog.backendtest.repository.AccountRepository;
import com.springboog.backendtest.service.RegisterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.Date;

import static com.springboog.backendtest.config.Constants.DATE_FORMAT;

@Service
public class RegisterServiceImpl implements RegisterService {

    @Autowired
    private AccountRepository accountRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public Account register(AccountDto dto) {
        Account account = new Account();
        account.setUsername(dto.getUsername());
        account.setPassword(passwordEncoder.encode(dto.getPassword()));
        account.setSalary(dto.getSalary());
        account.setType(getType(dto.getSalary()));
        account.setReferenceCode(getRefCode(dto.getUsername()));
        return accountRepository.save(account);
    }

    @Override
    public String getRefCode(String username) {
        SimpleDateFormat sdf = new SimpleDateFormat(DATE_FORMAT);
        StringBuilder ref = new StringBuilder(sdf.format(new Date()));
        ref.append(username.substring(username.length() - 4));
        return ref.toString();
    }

    @Override
    public Account.Type getType(int salary) {
        Account.Type type = null;
        if (salary > 50000) {
            type = Account.Type.PLATINUM;
        } else if (salary >= 30000) {
            type = Account.Type.GOLD;
        } else if (salary >= 15000) {
            type = Account.Type.SILVER;
        }
        return type;
    }

    @Override
    public Account getAccount(int id) {
        return accountRepository.findOne(id);
    }
}
