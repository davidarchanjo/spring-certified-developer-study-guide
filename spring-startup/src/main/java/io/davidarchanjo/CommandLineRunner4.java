package io.davidarchanjo;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Slf4j
@Order(1)
@Component
public class CommandLineRunner4 implements CommandLineRunner {

    @Override
    public void run(String... args) {
        log.info("Component CommandLineRunner4: {}", String.join(",", args));
    }
}
