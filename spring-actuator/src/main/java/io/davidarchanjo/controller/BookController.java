package io.davidarchanjo.controller;

import io.davidarchanjo.model.Book;
import io.davidarchanjo.repository.BookRepository;
import io.micrometer.core.instrument.Counter;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.ThreadLocalRandom;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("api/books")
public class BookController {

    private final Counter counter;
    private final BookRepository repository;

    @GetMapping
    public ResponseEntity<?> get() {
        log.info("Finding Book");
        return ResponseEntity.status(HttpStatus.OK)
            .body("Found Book");
    }

    @PostMapping
    public ResponseEntity<?> post() {
        log.info("Creating Book");
        Book body = repository.save(new Book(null, "Book-"+ThreadLocalRandom.current().nextInt()));
        counter.increment();
        return ResponseEntity.status(HttpStatus.CREATED)
            .body(body);
    }
}
