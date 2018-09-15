package com.aiwine.train.controller;

import com.aiwine.train.controller.response.AccountResponse;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.json.JacksonTester;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.mock.http.server.reactive.MockServerHttpRequest;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.junit.Assert.*;


@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class AccountControllerSpringBootMockTest {

    @Autowired
    private MockMvc mockMvc;

    private JacksonTester<AccountResponse> jacksonTester;

    @Test
    public void getById() throws Exception {

        JacksonTester.initFields(this, new ObjectMapper());

        MockHttpServletResponse response = mockMvc.perform(
                MockMvcRequestBuilders.get("/account/1")
                        .accept(MediaType.APPLICATION_JSON)
        ).andReturn().getResponse();

        assertEquals(HttpStatus.OK.value(), response.getStatus());

        AccountResponse expected = new AccountResponse("AAA", "aaa", 100000);
        assertEquals("Body is not expected.", jacksonTester.write(expected).getJson() , response.getContentAsString());
    }
}