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
@Table(name = "tb_order")
public class Order {

    @Id @GeneratedValue
    private Long id;
    private String title;
    private String description;
    private LocalDateTime createAt = LocalDateTime.now();

    @Builder
    public Order(String title, String description) {
        this.title = title;
        this.description = description;
    }
}
