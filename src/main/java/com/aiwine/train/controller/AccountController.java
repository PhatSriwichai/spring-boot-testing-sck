package com.aiwine.train.controller;

import com.aiwine.train.controller.response.AccountResponse;
import com.aiwine.train.exception.MyAccountNotFoundException;
import com.aiwine.train.model.Account;
import com.aiwine.train.repository.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.PostConstruct;
import java.util.Optional;

@RestController
public class AccountController {

    @Autowired
    private AccountRepository accountRepository;

    @GetMapping("/account/{id}")
    public AccountResponse getById(
            @PathVariable  int id
    ) {
        Optional<Account> account = accountRepository.findById(id);
        if (account.isPresent()) {
            Account myAccount = account.get();
            return new AccountResponse(
                    myAccount.getUserName(),
                    myAccount.getPassword(),
                    myAccount.getSlary()
            );
        }
        throw new MyAccountNotFoundException(String.format("Account id=[%d] not found.", id));
    }

    @PostConstruct
    public void initData() {
        Account account = new Account();
        account.setUserName("fake");
        account.setPassword("fake");
        account.setSlary(0);
        accountRepository.save(account);
    }
}
