package com.tmo.authenticationdemo.service;

import com.tmo.authenticationdemo.dto.AccountDto;


public interface AccountService {
    AccountDto createAccount(AccountDto accountDto);
    AccountDto getAccountById(Long id);
}
