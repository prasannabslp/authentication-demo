package com.tmo.authenticationdemo.service.impl;

import com.tmo.authenticationdemo.dto.AccountDto;
import com.tmo.authenticationdemo.entity.Account;
import com.tmo.authenticationdemo.mapper.AccountMapper;
import com.tmo.authenticationdemo.repository.AccountRepository;
import com.tmo.authenticationdemo.service.AccountService;
import org.springframework.stereotype.Service;

@Service
public class AccountServiceImpl implements AccountService {

    private AccountRepository accountRepository;

    public AccountServiceImpl(AccountRepository accountRepository){
        this.accountRepository = accountRepository;
    }

    public AccountDto createAccount(AccountDto accountDto){
        Account account = AccountMapper.mapToAccount(accountDto);
        Account savedAccount = accountRepository.save(account);
        return AccountMapper.mapToAccountDto(savedAccount);
    }

    @Override
    public AccountDto getAccountById(Long id) {
        Account account = accountRepository
                .findById(id)
                .orElseThrow(()->new RuntimeException("Account does not exist"));
        return AccountMapper.mapToAccountDto(account);
    }
}
