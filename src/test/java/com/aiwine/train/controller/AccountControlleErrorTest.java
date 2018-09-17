package com.aiwine.train.controller;

import com.aiwine.train.category.IntegrationTest;
import com.aiwine.train.controller.response.AccountResponse;
import com.aiwine.train.controller.response.ExceptionResponse;
import com.aiwine.train.repository.AccountRepository;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.*;
import static org.springframework.boot.test.context.SpringBootTest.WebEnvironment.RANDOM_PORT;


@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = RANDOM_PORT)
@Category(IntegrationTest.class)
public class AccountControlleErrorTest {

    @Autowired
    private TestRestTemplate testRestTemplate;

    @Autowired
    private AccountRepository accountRepository;


    @Test
    public void getByIdWithAccountNotFound() {
        // Clear Data
        try {
            accountRepository.deleteById(2);
        } catch(Exception e) {}

        // Action
        ResponseEntity<ExceptionResponse> result =
                testRestTemplate.getForEntity("/account/2", ExceptionResponse.class);

        assertEquals(HttpStatus.NOT_FOUND, result.getStatusCode());
        assertEquals("Account id=[2] not found.", result.getBody().getMessage());
        assertNotNull(result.getBody().getTimestamp());
    }
}