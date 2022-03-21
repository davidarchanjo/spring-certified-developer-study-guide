package io.davidarchanjo;

import lombok.AllArgsConstructor;
import lombok.ToString;

@ToString
@AllArgsConstructor
public class Bar implements Foo {

    private String name;

    @Override
    public void fuu() {
        System.out.println("Hi, " + name);
    }
}
