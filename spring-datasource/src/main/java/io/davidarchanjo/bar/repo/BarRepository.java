package io.davidarchanjo.bar.repo;

import io.davidarchanjo.bar.domain.Bar;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BarRepository extends JpaRepository<Bar, Long> {
}
