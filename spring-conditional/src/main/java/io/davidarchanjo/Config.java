package io.davidarchanjo;

import org.springframework.boot.autoconfigure.condition.ConditionalOnExpression;
import org.springframework.boot.autoconfigure.condition.ConditionalOnJava;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.autoconfigure.condition.ConditionalOnResource;
import org.springframework.boot.system.JavaVersion;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Conditional;
import org.springframework.context.annotation.Configuration;

@Configuration
public class Config {

    @Bean
    @ConditionalOnExpression("${module.enabled}") // is equivalent to @ConditionalOnExpression("'${module.enabled}'.equals('true')")
    public Clazz conditionalOnExpression() {
        return new Clazz("ConditionalOnExpression");
    }

    @Bean
    @ConditionalOnJava(JavaVersion.EIGHT)
    public Clazz conditionalOnJava() {
        return new Clazz("ConditionalOnJava");
    }

    @Bean
    @Conditional(ProductionEnvironmentCondition.class)
    public Clazz conditionalOnIsProductionEnvironment() {
        return new Clazz("ConditionalOnIsProductionEnvironment");
    }

    @Bean    
    @ConditionalOnProperty("module.enabled") //is equivalent to @ConditionalOnProperty(value="module.enabled", havingValue="true")
    public Clazz conditionalOnProperty() {
        return new Clazz("ConditionalOnProperty");
    }

    @Bean
    // @ConditionalOnResource(resources = "classpath:foo.properties")
    @ConditionalOnResource(resources = "file:/home/david_pereira/.h2.server.properties")
    public Clazz conditionalOnResource() {
        return new Clazz("ConditionalOnResource");
    }

    // @ConditionalOnBean(DataSource.class)

    // @ConditionalOnClass(DataSource.class)

    // @ConditionalOnCloudPlatform(CloudPlatform.Heroku)

    // @ConditionalOnJndi("java:comp/env/ejb/myEJB")

    // @ConditionalOnMissingBean(DataSource.class)

    // @ConditionalOnMissingClass(DataSource.class)

    // @ConditionalOnNotWebApplication    

    // @ConditionalOnSingleCandidate(DataSource.class)

    // @ConditionalOnWebApplication

}