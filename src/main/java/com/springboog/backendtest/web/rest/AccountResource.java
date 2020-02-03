package com.springboog.backendtest.web.rest;

import com.springboog.backendtest.domain.Account;
import com.springboog.backendtest.dto.AccountDto;
import com.springboog.backendtest.security.CustomerUserDetails;
import com.springboog.backendtest.service.RegisterService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;
import javax.validation.Valid;

@RestController
@RequestMapping("/api")
public class AccountResource {
    private final Logger log = LoggerFactory.getLogger(AccountResource.class);

    @Autowired
    private RegisterService registerService;

    @PostMapping("/register")
    public Account hello(@Valid @RequestBody AccountDto dto) {
        return registerService.register(dto);
    }

    @GetMapping("/account")
    public Account hello2(@AuthenticationPrincipal CustomerUserDetails userDetails) {
        log.debug("user {} ", userDetails);
        return registerService.getAccount(userDetails.getLoginId());
    }
}
