package io.example;

import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;

import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

import io.example.enums.Roles;
import io.example.model.dto.CreateUserDTO;
import io.example.service.impl.RoleServiceImpl;
import io.example.service.impl.UserServiceImpl;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Component
public class DatabaseInitializer implements ApplicationListener<ApplicationReadyEvent> {

    private final List<String> usernames = Arrays.asList(
        "david.pereira@btgpactual.com",
        "david.archanjo@btgpactual.com",
        "dennis.ritchie@nix.io"
    );
    private final List<String> fullNames = Arrays.asList(
        "David Pereira",
        "Alan Turing",
        "Dennis Ritchie"
    );
    private final List<String> roles = Arrays.asList(
        Roles.USER_ADMIN,
        Roles.AUTHOR_ADMIN,
        Roles.BOOK_ADMIN
    );

    private final UserServiceImpl userService;
    private final RoleServiceImpl roleService;

    @Override
    public void onApplicationEvent(ApplicationReadyEvent event) {
        roles.stream()
            .forEach(roleService::create);

        IntStream.range(0, 3).forEach(i -> {
            CreateUserDTO dto = CreateUserDTO.builder()
                .username(usernames.get(i))
                .fullName(fullNames.get(i))
                .password("248569ybr")
                .authorities(Arrays.asList(roles.get(i)))
                .build();

            userService.upsert(dto);
        });
    }

}
