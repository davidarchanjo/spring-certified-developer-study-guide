package io.davidarchanjo.controller;

import io.davidarchanjo.config.TestRestTemplateConfig;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.HttpStatus;
import org.springframework.test.context.ContextConfiguration;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.springframework.boot.test.context.SpringBootTest.WebEnvironment;

@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
@ContextConfiguration(classes = TestRestTemplateConfig.class) //or @Import(TestRestTemplateConfig.class)
class PostControllerTest {

    @LocalServerPort
    int serverPort;

    @MockBean
    TodoController todoController;

    @Autowired
    TestRestTemplate testRestTemplate;

    @Test
    void testGetForObject() {
        var url = "http://localhost:{port}/api/posts/getForObject";
        var respEntity = testRestTemplate.getForEntity(url, String.class, serverPort);
        assertThat(respEntity.getStatusCode()).isEqualTo(HttpStatus.OK);
        assertNotNull(respEntity.getBody());
    }

}