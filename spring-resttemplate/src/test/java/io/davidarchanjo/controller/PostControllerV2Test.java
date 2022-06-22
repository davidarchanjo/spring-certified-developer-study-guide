package io.davidarchanjo.controller;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpStatus;

@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
class PostControllerV2Test {    

    @Autowired
    private TestRestTemplate testRestTemplate;

    @Test
    void testGetForObject() {
        assertNotNull(testRestTemplate);
        var respEntity = testRestTemplate.getForEntity("/api/posts/getForObject", String.class);
        assertThat(respEntity.getStatusCode()).isEqualTo(HttpStatus.OK);
        assertNotNull(respEntity.getBody());
    }

}