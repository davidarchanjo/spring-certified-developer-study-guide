package io.davidarchanjo.controller;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.security.test.context.support.WithUserDetails;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
class PublicControllerTest {

    @Autowired
    private MockMvc mvc;

    @Test
    @WithUserDetails("david.archanjo@acme.com")
    void givenPublicGetApi_shouldBe200() throws Exception {
        mvc.perform(get("/api/public/get").contentType(MediaType.APPLICATION_JSON))
            .andExpect(content().string("Hello David Archanjo"))
            .andExpect(status().isOk());
    }

    @Test
    @WithUserDetails("bill.gates@acme.com")
    void givenPublicGetApi_shouldBe403() throws Exception {
        mvc.perform(get("/api/public/get").contentType(MediaType.APPLICATION_JSON))
            .andExpect(status().isForbidden());
    }
}