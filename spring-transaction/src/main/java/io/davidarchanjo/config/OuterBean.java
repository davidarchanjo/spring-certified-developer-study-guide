package io.davidarchanjo.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import io.davidarchanjo.model.domain.User;
import io.davidarchanjo.service.UserService;

@Component
@Transactional(propagation = Propagation.REQUIRED)
public class OuterBean {

    @Autowired
    private UserService testDAO;

    @Autowired
    private InnerBean innerBean;

    public void testRequired(User user) {
        testDAO.insertUser(user);
        try {
            innerBean.testRequired();
        } catch (RuntimeException ex) {
            // insert code here
        }
    }

    public void testRequiresNew(User user) {
        testDAO.insertUser(user);
        try {
            innerBean.testRequiresNew();
        } catch (RuntimeException ex) {
            // insert code here
        }
    }

    public void testNested(User user) {
        testDAO.insertUser(user);
        try {
            innerBean.testNested();
        } catch (RuntimeException ex) {
            ex.printStackTrace();
        }
    }

    public void testMandatory(User user) {
        testDAO.insertUser(user);
        try {
            innerBean.testMandatory();
        } catch (RuntimeException ex) {
            // insert code here
        }
    }

    public void testNever(User user) {
        testDAO.insertUser(user);
        try {
            innerBean.testNever();
        } catch (RuntimeException ex) {
            // insert code here
        }
    }

    public void testSupports(User user) {
        testDAO.insertUser(user);
        try {
            innerBean.testSupports();
        } catch (RuntimeException ex) {
            // insert code here
        }
    }

    public void testNotSupported(User user) {
        testDAO.insertUser(user);
        try {
            innerBean.testNotSupported();
        } catch (RuntimeException ex) {
            // insert code here
        }
    }
}