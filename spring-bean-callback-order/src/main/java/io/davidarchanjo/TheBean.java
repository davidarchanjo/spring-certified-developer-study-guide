package io.davidarchanjo;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class TheBean implements InitializingBean, DisposableBean {

    public TheBean() {        
        log.info("Bean's constructor");
    }

    public void initMethod() {
        log.info("Bean's init-method");
    }

    public void destroyMethod() {
        log.info("Bean's destroy-method");
    }

    @PostConstruct
    public void postConstruct() {
        log.info("@PostConstruct");
    }

    @PreDestroy
    public void preDestroy() {
        log.info("@PreDestroy");
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        log.info("InitializingBean's afterPropertiesSet");
    }

    @Override
    public void destroy() throws Exception {
        log.info("DisposableBean's destroy");
    }
}