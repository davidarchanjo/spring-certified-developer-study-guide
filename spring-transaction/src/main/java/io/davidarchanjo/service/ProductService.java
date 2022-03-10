package io.davidarchanjo.service;

import io.davidarchanjo.model.domain.Product;
import io.davidarchanjo.repository.ProductRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import lombok.val;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Slf4j
@Service
@AllArgsConstructor
@Transactional(readOnly = true)
public class ProductService {

    private final OrderService orderService;
    private final ProductRepository productRepository;

    // @Transactional(readOnly = true)/*(rollbackFor = { SQLException.class })*/
    public void createProduct1() throws Exception {
        log.info("----------- Creating Product-1 -----------");
        val prod = Product.builder()
            .title("Product Title")
            .price(10)
            .description("Product description")
            .build();
        productRepository.save(prod);
        log.info("----------- Product-1 Inserted -----------");
//        createProduct2();
//        orderService.createOrder();
//        throw new RuntimeException();
//            throw new SQLException();
    }

    // @Transactional(propagation = Propagation.SUPPORTS)
    public void createProduct2() throws Exception {
        log.info("----------- Creating Product-2 -----------");
        val prod = Product.builder()
            .title("Product Title")
            .price(10)
            .description("Product description")
            .build();
        productRepository.save(prod);        
        log.info("----------- Product-2 Inserted -----------");
        // orderService.createOrder();
        // throw new RuntimeException();
        // throw new SQLException();
    }
}
