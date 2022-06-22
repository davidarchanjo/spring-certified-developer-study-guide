package io.davidarchanjo;

import static org.junit.jupiter.api.Assertions.assertNotNull;

import javax.persistence.EntityManager;
import javax.sql.DataSource;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

@DataJpaTest
class DataJpaAccessTest {

    @Autowired
    private DataSource dataSource;

    @Autowired
    private EntityManager entityManager;

    @Test
    void testCustomNativeQuery() {
        assertNotNull(dataSource);
        assertNotNull(entityManager);
    }
}