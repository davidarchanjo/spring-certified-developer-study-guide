package io.davidarchanjo.foo.repo;

import io.davidarchanjo.foo.domain.Foo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FooRepository extends JpaRepository<Foo, Long> {
}
