package io.davidarchanjo.controller;

import static org.hamcrest.Matchers.containsString;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import io.davidarchanjo.service.GreetingService;

@WebMvcTest(GreetingController.class)
class WebLayerTest {

    @Autowired
    MockMvc mockMvc;

    @MockBean
    GreetingService service;

    @Test
    void greetingShouldReturnMessageFromService() throws Exception {
        when(service.greet()).thenReturn("Hello, World");

        this.mockMvc.perform(get("/"))
            .andDo(print())
            .andExpect(status().isOk())
            .andExpect(content().string(containsString("Hello, World")));
    }
}
