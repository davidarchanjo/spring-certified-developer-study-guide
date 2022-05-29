package io.davidarchanjo;

import org.springframework.boot.autoconfigure.condition.AnyNestedCondition;
import org.springframework.context.annotation.Conditional;

public class HmlOrPrdEnvironmentCondition extends AnyNestedCondition {
    
    HmlOrPrdEnvironmentCondition() {
        super(ConfigurationPhase.REGISTER_BEAN);
    }

    @Conditional(HmlEnvironmentCondition.class)
    static class HmlEnvironment { }

    @Conditional(PrdEnvironmentCondition.class)
    static class PrdEnvironment { }

}