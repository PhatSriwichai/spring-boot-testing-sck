package com.aiwine.train.repository;

import com.aiwine.train.controller.response.AccountResponse;
import com.aiwine.train.model.Account;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.data.mongo.DataMongoTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@DataJpaTest
//@DataMongoTest
public class AccountRepositoryTest {

    @Autowired
    private AccountRepository accountRepository;

    @Test
    public void creatNewAccount() {
        Account newAccount = new Account();
        newAccount.setUserName("AAA");
        newAccount.setPassword("aaa");
        newAccount.setSlary(100000);
        Account actualAccount = accountRepository.save(newAccount);

        assertNotEquals(0, actualAccount.getId());
        assertEquals(1, accountRepository.count());
    }

    @Test
    public void creatNewAccount2() {
        Account newAccount = new Account();
        newAccount.setUserName("AAA");
        newAccount.setPassword("aaa");
        newAccount.setSlary(100000);

        Account newAccount2 = new Account();
        accountRepository.save(newAccount);
        accountRepository.save(newAccount2);

        assertEquals(2, accountRepository.count());
    }

}