package io.davidarchanjo;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import lombok.Setter;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Setter
@Component
public class Triangle implements InitializingBean, DisposableBean {
    
    @Autowired    
    private Point pointA; // no need to use @Qualifier because the field has the same name of an existing bean for the Point type

    @Autowired
    private Point pointB;

    @Autowired
    private Point pointC;

    public void draw() {
        log.info("PointA is ({}, {})", pointA.getX(), pointA.getY());
        log.info("PointB is ({}, {})", pointB.getX(), pointB.getY());
        log.info("PointC is ({}, {})", pointC.getX(), pointC.getY());
    }

    @Override
    public void afterPropertiesSet() {
        log.info("Bean initialization method - triangle");
    }

    @Override
    public void destroy() {
        log.info("Bean destruction method - triangle");
    }

    @PostConstruct
    public void customInit() {
        log.info("@PostConstruct method - triangle");
    }

    @PreDestroy
    public void customDestroy() {
        log.info("@PreDestroy method - triangle");
    }
}