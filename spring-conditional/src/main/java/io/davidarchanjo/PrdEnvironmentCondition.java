package io.davidarchanjo;

import org.springframework.context.annotation.Condition;
import org.springframework.context.annotation.ConditionContext;
import org.springframework.core.env.Environment;
import org.springframework.core.type.AnnotatedTypeMetadata;

public class PrdEnvironmentCondition implements Condition {

    @Override
    public boolean matches(ConditionContext context, AnnotatedTypeMetadata metadata) {
        final Environment env = context.getEnvironment();                
        return env.containsProperty("ENVIRONMENT") && env.getProperty("ENVIRONMENT").equals("prd");
    }
}