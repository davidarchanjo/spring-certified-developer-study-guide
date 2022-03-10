package io.davidarchanjo.service;

import io.davidarchanjo.model.domain.Order;
import io.davidarchanjo.repository.OrderRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import lombok.val;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Slf4j
@Service
@AllArgsConstructor
@Transactional(propagation = Propagation.NEVER)
public class OrderService {

    private final OrderRepository orderRepository;

    @Transactional(propagation = Propagation.REQUIRES_NEW)
    public void createOrder() throws Exception {
        log.info("----------- Creating Order -----------");
        val order = Order.builder()
            .title("Order title")
            .description("Order description")
            .build();
        orderRepository.save(order);
        log.info("----------- Order Inserted -----------");
//        throw new RuntimeException();
    }
}
