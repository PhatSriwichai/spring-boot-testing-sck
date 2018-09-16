package com.aiwine.train.controller;

import com.aiwine.train.controller.response.AccountResponse;
import com.aiwine.train.model.Account;
import com.aiwine.train.repository.AccountRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Optional;

import static org.junit.Assert.*;
import static org.springframework.boot.test.context.SpringBootTest.WebEnvironment.RANDOM_PORT;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = RANDOM_PORT)
public class AccountControllerTest {

    @Autowired
    private TestRestTemplate testRestTemplate;

    @Autowired
    private AccountRepository accountRepository;

    @Test
    public void getById() {

        // Stub
        Account account = new Account();
        account.setUserName("fake");
        account.setPassword("fake");
        account.setSlary(0);
        accountRepository.save(account);

        ResponseEntity<AccountResponse> result =
                testRestTemplate.getForEntity("/account/1", AccountResponse.class);
        assertEquals(HttpStatus.OK, result.getStatusCode());

        AccountResponse expected = new AccountResponse("fake", "fake", 0);
        assertEquals(expected, result.getBody());
    }
}