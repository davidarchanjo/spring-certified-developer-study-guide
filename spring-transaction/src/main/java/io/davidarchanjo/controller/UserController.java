package io.davidarchanjo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.davidarchanjo.config.OuterBean;
import io.davidarchanjo.model.domain.User;

@RestController
@RequestMapping("api/users")
public class UserController {

    @Autowired
    private OuterBean outerBean;

    @PostMapping("required")
    public void testRequired() {
        User user = User.builder().name("David").build();
        outerBean.testRequired(user);
    }

    @PostMapping("requiresNew")
    public void testRequiresNew() {
        User user = User.builder().name("David").build();
        outerBean.testRequiresNew(user);
    }

    @PostMapping("nested")
    public void testNested() {
        User user = User.builder().name("David").build();
        outerBean.testNested(user);
    }

    @PostMapping("mandatory")
    public void testMandatory() {
        User user = User.builder().name("David").build();
        outerBean.testMandatory(user);
    }

    @PostMapping("never")
    public void testNever() {
        User user = User.builder().name("David").build();
        outerBean.testNever(user);
    }

    @PostMapping("supports")
    public void testSupports() {
        User user = User.builder().name("David").build();
        outerBean.testSupports(user);
    }

    @PostMapping("notSupported")
    public void testNotSupported() {
        User user = User.builder().name("David").build();
        outerBean.testNotSupported(user);
    }

}