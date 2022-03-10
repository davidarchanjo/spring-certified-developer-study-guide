package io.davidarchanjo.repository;

import io.davidarchanjo.model.domain.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Order, Long> {
}
