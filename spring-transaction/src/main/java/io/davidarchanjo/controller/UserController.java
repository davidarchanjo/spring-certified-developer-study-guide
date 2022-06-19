package io.davidarchanjo.controller;

import io.davidarchanjo.component.OuterBean;
import io.davidarchanjo.model.domain.User;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/users")
@RequiredArgsConstructor
public class UserController {

    private final OuterBean outerBean;

    @PostMapping("required")
    public void testRequired() {
        User user = User.builder().name("David").build();
        outerBean.testRequired(user); // USER NOT CREATED
    }

    @PostMapping("requiresNew")
    public void testRequiresNew() {
        User user = User.builder().name("David").build();
        outerBean.testRequiresNew(user); // USER CREATED
    }

    @PostMapping("nested")
    public void testNested() {
        User user = User.builder().name("David").build();
        outerBean.testNested(user); // USER CREATED
    }

    @PostMapping("mandatory")
    public void testMandatory() {
        User user = User.builder().name("David").build();
        outerBean.testMandatory(user); // USER NOT CREATED
    }

    @PostMapping("never")
    public void testNever() {
        User user = User.builder().name("David").build();
        outerBean.testNever(user); // USER CREATED
    }

    @PostMapping("supports")
    public void testSupports() {
        User user = User.builder().name("David").build();
        outerBean.testSupports(user); //USER NOT CREATED
    }

    @PostMapping("notSupported")
    public void testNotSupported() {
        User user = User.builder().name("David").build();
        outerBean.testNotSupported(user); // USER CREATED
    }

}