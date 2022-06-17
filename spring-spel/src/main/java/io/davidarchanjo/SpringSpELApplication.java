package io.davidarchanjo;

import java.util.Properties;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.expression.EvaluationContext;
import org.springframework.expression.Expression;
import org.springframework.expression.ExpressionParser;
import org.springframework.expression.spel.standard.SpelExpressionParser;
import org.springframework.expression.spel.support.StandardEvaluationContext;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@SpringBootApplication
public class SpringSpELApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringSpELApplication.class, args);
    }

    @Value("#{(3 * 9) + 3}")
    private int arithmetic;

    @Value("#{'Foo' + ' Bal'.replace('l', 'r')}")
    private String string;

    @Value("#{programmingLanguage.preferredLanguage}")
    private String preferredLanguage;

    @Value("#{programmingLanguage.name[0]}")
    private String mostPopularProgrammingLanguage;

    @Value("#{programmingLanguage.releaseYear[programmingLanguage.name[0]]}")
    private Float mostPopularProgrammingLanguageReleaseYear;

    @Value("#{'${foo}' + \"bar\".toUpperCase()}")
    private String fooBar;

    @Value("#{systemProperties['user.name']}")
    private String userName;

    @Value("#{systemProperties['user.language']}")
    private String userLanguage;

    @Value("#{'${my.name}'}") //accessing property defined on application.properties
    private String myName;

    @Value("#{systemEnvironment['JAVA_HOME']}")
    private String javaHome;
   
    @Value("#{systemProperties}")
    private Properties systemProperties;
   
    @Value("#{systemEnvironment}")
    private Properties systemEnvironment;

    // to access a static method from SpEl, the method must be static
    @Value("#{T(io.davidarchanjo.ToDo).getHello() eq 'hello'}")
    private boolean isHello;
    @Value("#{T(java.lang.Math).random()}")
    private double random;

    @Bean
    CommandLineRunner commandLineRunner() {
        return args -> {
            log.info("ARITHMETIC: {}\n", arithmetic);
            log.info("STRING: {}\n", string);
            log.info("PREFERREDLANGUAGE: {}\n", preferredLanguage);
            log.info("MOST_POPULAR_PROGRAMMING_LANGUAGE: {}\n", mostPopularProgrammingLanguage);
            log.info("RELEASE_YEAR: {}\n", mostPopularProgrammingLanguageReleaseYear);
            log.info("FOOBAR: {}\n", fooBar);
            log.info("MY_NAME: {}\n", myName);
            log.info("USER_NAME: {}\n", userName);
            log.info("USER_LANGUAGE: {}\n", userLanguage);
            log.info("JAVA_HOME: {}\n", javaHome);
            log.info("SYSTEM_PROPERTIES: {}\n", systemProperties);
            log.info("SYSTEM_ENVIRONMENT: {}\n", systemEnvironment);
            log.info("ISHELLO: {}\n", isHello);
            log.info("RANDOM: {}\n", random);

            ToDo toDo = ToDo.builder()
                .task("Studying Java")
                .completed(false)
                .build();

            ExpressionParser expressionParser = new SpelExpressionParser();
            Expression expression = expressionParser.parseExpression("task");
            EvaluationContext context = new StandardEvaluationContext(toDo);
            String result = (String) expression.getValue(context);
            // log.info("ORIGINAL_EXPRESSION_VALUE: {}\n", result);

            context = new StandardEvaluationContext(toDo);
            expressionParser = new SpelExpressionParser();
            expressionParser.parseExpression("task").setValue(context, "Studying Spring");
            result = (String) expression.getValue(context);
            // log.info("UPDATED_EXPRESSION_VALUE: {}\n", result);
        };
    }
}