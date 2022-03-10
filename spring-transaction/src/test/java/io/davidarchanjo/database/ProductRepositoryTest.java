package io.davidarchanjo.database;

import io.davidarchanjo.model.domain.Product;
import io.davidarchanjo.repository.ProductRepository;
import lombok.extern.slf4j.Slf4j;
import lombok.val;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@Slf4j
@DataJpaTest
class ProductRepositoryTest {

    @Autowired
    private ProductRepository productRepository;

    @Test
    void createProduct() {
        val todo = Product.builder()
            .description("Product Description")
            .price(1)
            .title("Product Title")
            .build();
        productRepository.save(todo);

        val todo$ = productRepository.findById(todo.getId());
        assertNotNull(todo$);
        assertEquals(todo, todo$.get());
    }

}
