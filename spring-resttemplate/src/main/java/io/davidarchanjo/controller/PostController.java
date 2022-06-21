package io.davidarchanjo.controller;

import io.davidarchanjo.model.Post;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.HttpStatusCodeException;
import org.springframework.web.client.RestTemplate;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.Set;

@Slf4j
@RestController
@RequestMapping("api/posts")
@RequiredArgsConstructor
public class PostController {

    private static final String URL = "https://jsonplaceholder.typicode.com/posts";
    private final RestTemplate restTemplate;

    @GetMapping("getForObject")
    public Post[] testGetForObject() {
        var result = restTemplate.getForObject(URL, Post[].class);
        return result;
    }

    @GetMapping("getForObjectWithUrlParameters")
    public Post testGetForObjectWithUrlParameters() {
        var result = restTemplate.getForObject(URL + "/{id}", Post.class, 1);
        return result;
    }

    @GetMapping("getForEntity")
    public Post testGetForEntity() {
        var response = restTemplate.getForEntity(URL + "/{id}", Post.class, 1);
        return (response.getStatusCode().is2xxSuccessful())
            ? response.getBody() : null;
    }

    @GetMapping("exchangeGet")
    public Post testExchangeGet() {
        var headers = new HttpHeaders();
        headers.setAccept(Collections.singletonList(MediaType.APPLICATION_JSON));
        headers.set("x-request-src", "desktop");

        var entity = new HttpEntity<>("body", headers);
        var response = restTemplate.exchange(URL + "/{id}", HttpMethod.GET, entity, Post.class, 1);
        return (response.getStatusCode().is2xxSuccessful())
            ? response.getBody() : null;
    }

    @GetMapping("postForEntity")
    public Post testPostForEntity() {
        var headers = new HttpHeaders();        
        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.setAccept(Collections.singletonList(MediaType.APPLICATION_JSON));
        
        var map = new HashMap<String, Object>();
        map.put("userId", 1);
        map.put("title", "Spring Certified Developer");
        map.put("body", "Spring Certified Developer makes your studies more easy to do.");

        var entity = new HttpEntity<Map<String, Object>>(map, headers);
        var response = restTemplate.postForEntity(URL, entity, Post.class);
        return (response.getStatusCode().is2xxSuccessful()) 
            ? response.getBody() : null;
    }

    @GetMapping("postForObject")
    public Post testPostForObject() {
        var headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.setAccept(Collections.singletonList(MediaType.APPLICATION_JSON));

        var post = new Post(null, 1L, "Introduction to Spring Boot",
            "Spring Boot makes it easy to create stand-alone, production-grade Spring based Applications.");
        var entity = new HttpEntity<>(post, headers);
        var result = restTemplate.postForObject(URL, entity, Post.class);
        return result;
    }

    @GetMapping("put")
    public void testPut() {
        var headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.setAccept(Collections.singletonList(MediaType.APPLICATION_JSON));

        var post = new Post(null, 4L, "New Title", "New Body");
        var entity = new HttpEntity<Post>(post, headers);
        restTemplate.put(URL + "/{id}", entity, 10);
    }

    @GetMapping("exchangePut")
    public Post testExchangePut() {
        var headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.setAccept(Collections.singletonList(MediaType.APPLICATION_JSON));

        var post = new Post(null, 4L, "New Title", "New Body");
        var entity = new HttpEntity<Post>(post, headers);
        var response = restTemplate.exchange(URL + "/{id}", HttpMethod.PUT, entity, Post.class, 10);

        return (response.getStatusCode().is2xxSuccessful())
            ? response.getBody() : null;
    }

    @DeleteMapping("delete")
    public void testDeletePost() {
        restTemplate.delete(URL + "/{id}", 10);
    }

    @GetMapping("retrieveHeaders")
    public HttpHeaders testRetrieveHeaders() {
        var result = restTemplate.headForHeaders(URL);
        return result;
    }

    @GetMapping("allowedOperations")
    public Set<HttpMethod> testAllowedOperations() {
        var result = restTemplate.optionsForAllow(URL);
        return result;
    }

    @GetMapping("notFoundRequest")
    public String testNotFoundRequest() {
        String result = null;
        try {
            result = restTemplate.getForObject(URL + "/{id}", String.class, 404);
        } catch (HttpStatusCodeException ex) {            
            log.info("STATUSCODE: {}", ex.getStatusCode());
            log.info("RAWSTATUSCODE: {}", ex.getRawStatusCode());
            log.info("RESPONSEBODYASSTRING: {}", ex.getResponseBodyAsString());

            var headers = ex.getResponseHeaders();
            if (Objects.nonNull(headers)) {
                log.info("HEADER_SERVER: {}", headers.get("Server"));
                log.info("HEADER_CONTENT-TYPE: {}", headers.get("Content-Type"));   
            }            
        }
        return result;
    }
}
