package io.davidarchanjo.repository;

import org.springframework.data.repository.CrudRepository;

import io.davidarchanjo.model.Book;

import java.util.List;

public interface BookRepository extends CrudRepository<Book, Long> {

    List<Book> findByName(String name);
}
