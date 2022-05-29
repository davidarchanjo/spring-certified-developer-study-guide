package io.davidarchanjo;

import javax.sql.DataSource;

import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
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
    public String conditionalOnExpression() {
        return "ConditionalOnExpression";
    }

    @Bean
    @ConditionalOnJava(JavaVersion.EIGHT)
    public String conditionalOnJava() {
        return "ConditionalOnJava";
    }

    @Bean
    @Conditional({PrdEnvironmentCondition.class})
    public String conditionalOnIsProductionEnvironment() {
        return "ConditionalOnIsProductionEnvironment";
    }

    @Bean
    @Conditional({HmlOrPrdEnvironmentCondition.class})
    public String conditionalOnIsHmlOrPrdEnvironment() {
        return "ConditionalOnIsHmlOrPrdEnvironment";
    }

    @Bean    
    @ConditionalOnProperty(value="module.disabled", matchIfMissing=true) // is equivalent to @ConditionalOnProperty(value="module.enabled", havingValue="true")
    public String conditionalOnProperty() {
        return "ConditionalOnProperty";
    }

    @Bean
    // @ConditionalOnResource(resources = "classpath:foo.properties")
    @ConditionalOnResource(resources = {"file:/home/david_pereira/.bashrc"})
    public String conditionalOnResource() {
        return "ConditionalOnResource";
    }

    // @ConditionalOnBean(DataSource.class)

    @ConditionalOnClass({Clazz.class})
    public String conditionalOnClass() {
        return "ConditionalOnClass";
    }

    // @ConditionalOnCloudPlatform(CloudPlatform.Heroku)

    // @ConditionalOnJndi("java:comp/env/ejb/myEJB")

    // @ConditionalOnMissingBean(DataSource.class)

    // @ConditionalOnMissingClass(DataSource.class)

    // @ConditionalOnNotWebApplication    

    // @ConditionalOnSingleCandidate(DataSource.class)

    // @ConditionalOnWebApplication

}