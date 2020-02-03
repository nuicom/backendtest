package com.springboog.backendtest.service;

import com.springboog.backendtest.domain.Account;
import com.springboog.backendtest.dto.AccountDto;

public interface RegisterService {
    Account register(AccountDto accountDto);

    String getRefCode(String username);

    Account.Type getType(int salary);

    Account getAccount(int id);
}
