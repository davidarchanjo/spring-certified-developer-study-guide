package io.davidarchanjo.repository;

import io.davidarchanjo.model.domain.Product;
import io.davidarchanjo.service.ProductService;
import lombok.extern.slf4j.Slf4j;
import lombok.val;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.annotation.*;
import org.springframework.transaction.annotation.Transactional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@Slf4j
@DataJpaTest
@Transactional
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
class ProductRepositoryTest {

    @MockBean
    private ProductService productService;

    @Autowired
    private ProductRepository productRepository;

    @Test
//    @Commit
    @Rollback
    void createProduct() {
        val todo = Product.builder()
            .description("Test Description")
            .price(1)
            .title("Test Title")
            .build();
        productRepository.save(todo);

        val todo$ = productRepository.findById(todo.getId());
        assertNotNull(todo$);
        assertEquals(todo, todo$.get());
    }

}
