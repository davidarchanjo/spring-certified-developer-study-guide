package io.davidarchanjo;

import java.util.concurrent.ThreadLocalRandom;

import lombok.ToString;

@ToString
public class Bar {
    private long id = ThreadLocalRandom.current().nextInt();
}
