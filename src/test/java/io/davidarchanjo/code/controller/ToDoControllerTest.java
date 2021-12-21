package io.davidarchanjo.code.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import io.davidarchanjo.code.model.dto.ToDoDTO;
import io.davidarchanjo.code.service.ToDoService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.web.servlet.MockMvc;

import static org.hamcrest.Matchers.is;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(controllers = ToDoController.class)
public class ToDoControllerTest {

    @Value("${foo}")
    private String foo;

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    @MockBean
    private ToDoService service;

    @Test
    void shouldReturnHttpError400() throws Exception {
        final ToDoDTO body = ToDoDTO.builder().build();
        mockMvc.perform(post("/api/todo")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(body)))
            .andDo(print())
            .andExpect(status().isBadRequest())
            .andExpect(jsonPath("$.details[0]", is("Attribute 'completed' must not be null")))
            .andExpect(jsonPath("$.details[1]", is("Attribute 'task' must not be null")));
    }
}
