package io.davidarchanjo.repository;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.annotation.Commit;
import org.springframework.transaction.annotation.Transactional;

import io.davidarchanjo.model.domain.User;

@DataJpaTest
@Transactional
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
class UserRepositoryTest {    

    @Autowired
    UserRepository userRepository;

    @Test
    @Commit
    // @Rollback
    void createUser() {
        User user = userRepository.save(User.builder()
            .name("user #1")
            .build());

        User user$ = userRepository.findById(user.getId()).get();
        assertNotNull(user$);
        assertEquals(user, user$);
    }

}
