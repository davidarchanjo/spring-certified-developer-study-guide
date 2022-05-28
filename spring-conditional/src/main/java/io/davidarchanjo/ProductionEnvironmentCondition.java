package io.davidarchanjo;

import org.springframework.context.annotation.Condition;
import org.springframework.context.annotation.ConditionContext;
import org.springframework.core.env.Environment;
import org.springframework.core.type.AnnotatedTypeMetadata;

public class ProductionEnvironmentCondition implements Condition {

    @Override
    public boolean matches(ConditionContext context, AnnotatedTypeMetadata metadata) {
        final Environment env = context.getEnvironment();                
        return env.containsProperty("ENVIRONMENT") && env.getProperty("ENVIRONMENT").equals("prd");
    }
    // vmArgs variables overwrite OS environment and application.properties variables
    // OS env variables overwrite application.properties
}