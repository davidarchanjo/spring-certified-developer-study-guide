package io.davidarchanjo;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;

import javax.annotation.PostConstruct;

@Slf4j
public class TheBean implements InitializingBean, DisposableBean {

    public TheBean() {
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
    }

    @Override
    public void destroy() throws Exception {
        log.info("disposableBean's destroy method");
    }
}