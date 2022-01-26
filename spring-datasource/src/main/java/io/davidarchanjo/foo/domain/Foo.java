package io.davidarchanjo.foo.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@Table(name = "FOO")
@NoArgsConstructor
public class Foo {

    @Id
    @GeneratedValue
    @Column(name = "ID")
    private Long id;
    @Column(name = "NAME")
    private String name;

    @Builder
    public Foo(Long id, String name) {
        this.id = id;
        this.name = name;
    }
}
