package com.aiwine.train.controller;

import com.aiwine.train.controller.response.AccountResponse;
import com.aiwine.train.model.Account;
import com.aiwine.train.repository.AccountRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.json.JacksonTester;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.util.Optional;

import static org.junit.Assert.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.BDDMockito.given;

@RunWith(SpringRunner.class)
@WebMvcTest(AccountController.class)
public class AccountControllerWebMvcTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private AccountRepository accountRepository;

    private JacksonTester<AccountResponse> jacksonTester;

    @Test
    public void getById() throws Exception {

        JacksonTester.initFields(this, new ObjectMapper());

        // Stub
        Account account = new Account();
        account.setUserName("AAA");
        account.setPassword("aaa");
        account.setSlary(100000);
        given(accountRepository.findById(1)).willReturn(Optional.of(account));

        MockHttpServletResponse response = mockMvc.perform(
                MockMvcRequestBuilders.get("/account/1")
                        .accept(MediaType.APPLICATION_JSON)
        ).andReturn().getResponse();

        AccountResponse expected = new AccountResponse("AAA", "aaa", 100000);
        assertEquals(HttpStatus.OK.value(), response.getStatus());

        assertEquals("Body is not expected.", jacksonTester.write(expected).getJson() , response.getContentAsString());
    }
}