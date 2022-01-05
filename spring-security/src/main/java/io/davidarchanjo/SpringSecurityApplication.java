package io.davidarchanjo;

import java.util.List;
import java.util.stream.IntStream;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import io.davidarchanjo.enums.Roles;
import io.davidarchanjo.model.dto.CreateUserDTO;
import io.davidarchanjo.service.RoleService;
import io.davidarchanjo.service.UserService;

@SpringBootApplication
public class SpringSecurityApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringSecurityApplication.class, args);
    }

    @Bean
    CommandLineRunner commandLineRunner(UserService userService, RoleService roleService) {
        return args -> {
            List<String> usernames = List.of(
                "david.pereira@btgpactual.com",
                "alan.turing@btgpactual.com",
                "dennis.ritchie@nix.io"
            );
            List<String> fullNames = List.of(
                "David Pereira",
                "Alan Turing",
                "Dennis Ritchie"
            );
            List<String> roles = List.of(
                Roles.USER_ADMIN,
                Roles.AUTHOR_ADMIN,
                Roles.BOOK_ADMIN
            );
            roles.stream().forEach(roleService::create);
            IntStream.range(0, 3).forEach(i -> userService.upsert(CreateUserDTO.builder()
               .username(usernames.get(i))
               .fullName(fullNames.get(i))
               .password("248569ybr")
               .authorities(List.of(roles.get(i)))                    
               .build()));
        };
    }
    
}