package io.davidarchanjo;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Slf4j
@Order(2)
@Component
public class CommandLineRunner3 implements CommandLineRunner {

    @Override
    public void run(String... args) {
        log.info("Component CommandLineRunner3: {}", String.join(",", args));
    }
}
