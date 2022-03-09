package io.davidarchanjo.model.domain;

import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@Entity
@Table(name = "tb_product")
public class Product {

    @Id @GeneratedValue
    private Long id;
    private String title;
    private Integer price;
    private String description;
    private LocalDateTime createAt = LocalDateTime.now();

    @Builder
    public Product(String title, Integer price, String description) {
        this.title = title;
        this.price = price;
        this.description = description;
    }
}
