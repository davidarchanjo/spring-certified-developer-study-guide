package io.davidarchanjo;

import lombok.extern.slf4j.Slf4j;
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

@Slf4j
@SpringBootApplication
public class SpringSpELApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringSpELApplication.class, args);
    }

    @Value("#{(3 * 9) + 3}")
    private int arithmetic;

    @Value("#{'Foo' + ' Bal'.replace('l', 'r')}") // or .replace(\"l\", \"r\")
    private String string;

    @Value("#{programmingLanguage.name[0]}")
    private String mostPopularProgrammingLanguage;

    @Value("#{programmingLanguage.releaseYear[programmingLanguage.name[0]]}")
    private Float mostPopularProgrammingLanguageReleaseYear;

    @Bean
    CommandLineRunner commandLineRunner2() {
        return args -> {
            log.info("ARITHMETIC: {}", arithmetic);
            log.info("STRING: {}", string);
            log.info("MOST_POPULAR_PROGRAMMING_LANGUAGE: {}", mostPopularProgrammingLanguage);
            log.info("RELEASE_YEAR: {}", mostPopularProgrammingLanguageReleaseYear);

            ToDo toDo = ToDo.builder()
                .task("Studying Java")
                .completed(false)
                .build();

            ExpressionParser expressionParser = new SpelExpressionParser();
            Expression expression = expressionParser.parseExpression("task");
            EvaluationContext context = new StandardEvaluationContext(toDo);
            String result = (String) expression.getValue(context);
            log.info("ORIGINAL_EXPRESSION_VALUE: {}", result);

            context = new StandardEvaluationContext(toDo);
            expressionParser = new SpelExpressionParser();
            expressionParser.parseExpression("task").setValue(context, "Studying Spring");
            result = (String) expression.getValue(context);
            log.info("UPDATED_EXPRESSION_VALUE: {}", result);
        };
    }
}