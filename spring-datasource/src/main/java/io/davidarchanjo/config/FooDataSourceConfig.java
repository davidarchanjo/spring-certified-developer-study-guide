package io.davidarchanjo.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.boot.orm.jpa.EntityManagerFactoryBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.jdbc.datasource.init.DatabasePopulator;
import org.springframework.jdbc.datasource.init.DatabasePopulatorUtils;
import org.springframework.jdbc.datasource.init.ResourceDatabasePopulator;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;

@Configuration
@EnableTransactionManagement
@EnableJpaRepositories(
    entityManagerFactoryRef = "entityManagerFactory",
    basePackages = { "io.davidarchanjo.foo.repo" }
)
public class FooDataSourceConfig {

    @Primary
    @Bean
    public DataSource dataSource(
        @Value("${foo.datasource.url}") String url,
        @Value("${foo.datasource.username}") String username,
        @Value("${foo.datasource.password}") String password,
        @Value("${foo.datasource.driver-class-name}") String driverClassName
    ) {
        DataSourceBuilder dataSourceBuilder = DataSourceBuilder.create();
        dataSourceBuilder.url(url);
        dataSourceBuilder.username(username);
        dataSourceBuilder.password(password);
        dataSourceBuilder.driverClassName(driverClassName);
        DataSource dataSource = dataSourceBuilder.build();

        Resource initSchema = new ClassPathResource("schema-h2.sql");
        Resource initData = new ClassPathResource("data-h2.sql");
        DatabasePopulator databasePopulator = new ResourceDatabasePopulator(initSchema, initData);
        DatabasePopulatorUtils.execute(databasePopulator, dataSource);

        return dataSource;
    }

    @Primary
    @Bean
    public LocalContainerEntityManagerFactoryBean entityManagerFactory(
        EntityManagerFactoryBuilder builder,
        DataSource dataSource
    ) {
        return builder.dataSource(dataSource)
            .packages("io.davidarchanjo.foo.domain")
            .persistenceUnit("foo")
            .build();
    }

    @Primary
    @Bean
    public PlatformTransactionManager transactionManager(
        EntityManagerFactory entityManagerFactory
    ) {
        return new JpaTransactionManager(entityManagerFactory);
    }
}