package com.aiwine.train.controller;

import com.aiwine.train.controller.response.AccountResponse;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
public class AccountControllerUnitTest {

    private AccountController accountController;

    @Test
    public void getById() {
        accountController = new AccountController();
        AccountResponse response = accountController.getById(1);
        AccountResponse expected = new AccountResponse("AAA", "aaa", 100000);
        assertEquals(expected, response);
    }
}