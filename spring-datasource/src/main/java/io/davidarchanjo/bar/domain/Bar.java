package io.davidarchanjo.bar.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.*;

import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@Table(name = "BAR")
@NoArgsConstructor
public class Bar {

    @Id
    @GeneratedValue
    @Column(name = "ID")
    private Long id;
    @Column(name = "NAME")
    private String name;

    @Builder
    public Bar(Long id, String name) {
        this.id = id;
        this.name = name;
    }

}
