package io.davidarchanjo.controller;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.head;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.options;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.header;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.web.servlet.MockMvc;

@ActiveProfiles("test")
@WebMvcTest(controllers = MyController.class)
class MyControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    void testHead() throws Exception {
        this.mockMvc.perform(head("/test"))
            .andExpect(status().isOk())
            .andDo(print());
    }

    @Test
    void testGet() throws Exception {
        this.mockMvc.perform(get("/test"))
            .andExpect(status().isOk())
            .andDo(print());
    }

    @Test
    void testOptions() throws Exception {
        this.mockMvc.perform(options("/test"))
            .andExpect(status().isOk())
            .andExpect(header().string("Allow", "GET,HEAD,OPTIONS"))
            .andDo(print());
    }
}