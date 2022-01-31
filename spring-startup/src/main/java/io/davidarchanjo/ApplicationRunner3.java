package io.davidarchanjo;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class ApplicationRunner3 implements ApplicationRunner {

    @Override
    public void run(ApplicationArguments args) {
        log.info("Component ApplicationRunner3: {}", String.join(",", args.getSourceArgs()));
    }
}
