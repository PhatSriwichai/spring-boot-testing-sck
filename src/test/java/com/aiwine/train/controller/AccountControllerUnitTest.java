package com.aiwine.train.controller;

import com.aiwine.train.controller.response.AccountResponse;
import com.aiwine.train.model.Account;
import com.aiwine.train.repository.AccountRepository;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Optional;

import static org.junit.Assert.*;
import static org.mockito.BDDMockito.given;
import static org.mockito.MockitoAnnotations.initMocks;

//@RunWith(MockitoJUnitRunner.class)
public class AccountControllerUnitTest {

    @Mock
    private AccountRepository repository;

    private AccountController accountController;

//    @BeforeClass
//    public void initialOnce() {
//        // run when start class
//    }

    // Do Before by test case
    @Before
    public void initial() {
        initMocks(this);
    }

    @Test
    public void getById() {

        // Stub
        Account account = new Account();
        account.setUserName("AAA");
        account.setPassword("aaa");
        account.setSlary(100000);
        given(repository.findById(1)).willReturn(Optional.of(account));

        accountController = new AccountController(repository);
        AccountResponse response = accountController.getById(1);
        AccountResponse expected = new AccountResponse("AAA", "aaa", 100000);
        assertEquals(expected, response);
    }
}