package io.davidarchanjo.controller;

import static org.hamcrest.Matchers.is;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.redirectedUrlPattern;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;

import com.fasterxml.jackson.databind.ObjectMapper;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import io.davidarchanjo.model.dto.ToDoDTO;
import io.davidarchanjo.service.ToDoService;

@WebMvcTest(controllers = ToDoController.class)
public class ToDoControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    @MockBean
    private ToDoService service;

    @Test
    void shouldReturnHttpError400() throws Exception {
        final ToDoDTO body = ToDoDTO.builder().build();
        mockMvc.perform(post("/api/todos")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(body)))
            .andDo(print())
            .andExpect(status().isBadRequest())
            .andExpect(jsonPath("$.details[0]", is("Attribute 'completed' must not be null")))
            .andExpect(jsonPath("$.details[1]", is("Attribute 'task' must not be null")));
    }

    @Test
    void shouldCreateNewToDo_WithSuccess() throws Exception {
        final ToDoDTO dto = ToDoDTO.builder()
            .task("Wash The Dishes")
            .completed(false)
            .build();

        when(service.create(dto))
            .thenReturn(dto.toBuilder().id(1L).build());

        mockMvc.perform(post("/api/todos")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(dto)))
            .andDo(print())
            .andExpect(redirectedUrlPattern("http://*/api/todos/1"))
            .andExpect(status().isCreated());
    }

    @Test
    void shouldFindById_WithSuccess() throws Exception {
        final ToDoDTO dto = ToDoDTO.builder()
            .id(1L)
            .task("Home Work")
            .completed(true)
            .build();

        when(service.findById(1L))
            .thenReturn(dto);

        mockMvc.perform(get("/api/todos/{id}", dto.getId())
                .accept(MediaType.APPLICATION_JSON))
            .andDo(print())
            .andExpect(status().isOk())
            .andExpect(jsonPath("$.id", is(dto.getId().intValue())))
            .andExpect(jsonPath("$.task", is("Home Work")))
            .andExpect(jsonPath("$.completed", is(true)));
    }

    //    @Test
//    void testGetEmployeesByName()
//    {
//        Employee employee = new Employee();
//        employee.setId(1);
//        employee.setName("Test");
//        employee.setSalary(1000);
//
//        List<Employee> list = new ArrayList<Employee>();
//        list.add(employee);
//
//        Flux<Employee> employeeFlux = Flux.fromIterable(list);
//
//        Mockito
//            .when(repository.findByName("Test"))
//            .thenReturn(employeeFlux);
//
//        webClient.get().uri("/name/{name}", "Test")
//            .header(HttpHeaders.ACCEPT, "application/json")
//            .exchange()
//            .expectStatus().isOk()
//            .expectBodyList(Employee.class);
//
//        Mockito.verify(repository, times(1)).findByName("Test");
//    }
//
//    @Test
//    void testGetEmployeeById()
//    {
//        Employee employee = new Employee();
//        employee.setId(100);
//        employee.setName("Test");
//        employee.setSalary(1000);
//
//        Mockito
//            .when(repository.findById(100))
//            .thenReturn(Mono.just(employee));
//
//        webClient.get().uri("/{id}", 100)
//            .exchange()
//            .expectStatus().isOk()
//            .expectBody()
//            .jsonPath("$.name").isNotEmpty()
//            .jsonPath("$.id").isEqualTo(100)
//            .jsonPath("$.name").isEqualTo("Test")
//            .jsonPath("$.salary").isEqualTo(1000);
//
//        Mockito.verify(repository, times(1)).findById(100);
//    }
//
//    @Test
//    void testDeleteEmployee()
//    {
//        Mono<Void> voidReturn  = Mono.empty();
//        Mockito
//            .when(repository.deleteById(1))
//            .thenReturn(voidReturn);
//
//        webClient.get().uri("/delete/{id}", 1)
//            .exchange()
//            .expectStatus().isOk();
//    }

}
