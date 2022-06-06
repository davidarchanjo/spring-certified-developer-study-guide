package io.davidarchanjo;

import java.util.Objects;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;

import lombok.Data;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Data
public class TheBean implements InitializingBean, DisposableBean {

    private String name;

    public TheBean(String name) {
        this.name = name;
        log.info("constructor");
    }

    public void initMethod() {
        log.info("bean init method");
    }

    public void destroyMethod() {
        log.info("bean destroy method");
    }

    @PostConstruct
    public void postConstruct() {
        log.info("postConstruct method");
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        log.info("initializingBean's afterPropertiesSet method");        
        log.info("name is null: {}, value: {}", Objects.isNull(this.name), this.name);

        this.name = "FooBar";
        log.info("name new value: {}", this.name);
    }

    @Override
    public void destroy() throws Exception {
        log.info("disposableBean's destroy method");
    }
}