package com.aiwine.train.controller;

import com.aiwine.train.category.UnitTest;
import com.aiwine.train.controller.response.AccountResponse;
import com.aiwine.train.exception.MyAccountNotFoundException;
import com.aiwine.train.model.Account;
import com.aiwine.train.repository.AccountRepository;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Rule;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.junit.rules.ExpectedException;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Optional;

import static org.junit.Assert.*;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.when;
import static org.mockito.MockitoAnnotations.initMocks;

//@RunWith(MockitoJUnitRunner.class)
@Category(UnitTest.class)
public class AccountControllerErrorUnitTest {

    @Mock
    private AccountRepository repository;

    private AccountController accountController;

    // Do Before by test case
    @Before
    public void initial() {
        initMocks(this);
    }

    @Test(expected = MyAccountNotFoundException.class)
    public void getByIdWithException() {

        // Stub
        given(repository.findById(2))
                .willReturn(Optional.empty());
//                .willThrow(new MyAccountNotFoundException("Fail na"));

        accountController = new AccountController(repository);
        AccountResponse response = accountController.getById(2);
    }

    @Rule
    public ExpectedException thrown = ExpectedException.none();

    @Test
    public void getByIdWithExceptionWithRule() {

        // Stub
        when(repository.findById(2))
                .thenReturn(Optional.empty());

        accountController = new AccountController(repository);
        thrown.expect(MyAccountNotFoundException.class);
        thrown.expectMessage("Account id=[2] not found.");
        AccountResponse response = accountController.getById(2);
    }
}