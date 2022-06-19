package io.davidarchanjo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import io.davidarchanjo.model.domain.User;

public interface UserRepository extends JpaRepository<User, Long> {

    User findByName(String name);
}
