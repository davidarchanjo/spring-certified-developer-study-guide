package io.davidarchanjo.component;

import io.davidarchanjo.model.domain.User;
import io.davidarchanjo.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor
@Component
@Transactional(propagation = Propagation.REQUIRED)
public class OuterBean {

    private final UserService userService;
    private final InnerBean innerBean;

    public void testRequired(User user) {
        userService.insertUser(user);
        try {
            innerBean.testRequired();
        } catch (RuntimeException ex) {
            // insert code here
        }
    }

    public void testRequiresNew(User user) {
        userService.insertUser(user);
        try {
            innerBean.testRequiresNew();
        } catch (RuntimeException ex) {
            // insert code here
        }
    }

    public void testNested(User user) {
        userService.insertUser(user);
        try {
            innerBean.testNested();
        } catch (RuntimeException ex) {
            ex.printStackTrace();
        }
    }

    public void testMandatory(User user) {
        userService.insertUser(user);
        try {
            innerBean.testMandatory();
        } catch (RuntimeException ex) {
            // insert code here
        }
    }

    public void testNever(User user) {
        userService.insertUser(user);
        try {
            innerBean.testNever();
        } catch (RuntimeException ex) {
            // insert code here
        }
    }

    public void testSupports(User user) {
        userService.insertUser(user);
        try {
            innerBean.testSupports();
        } catch (RuntimeException ex) {
            // insert code here
        }
    }

    public void testNotSupported(User user) {
        userService.insertUser(user);
        try {
            innerBean.testNotSupported();
        } catch (RuntimeException ex) {
            // insert code here
        }
    }
}