package io.davidarchanjo.component;

import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Component
public class InnerBean {

    @Transactional(propagation = Propagation.REQUIRED)
    public void testRequired() {
        throw new RuntimeException("Rollback this transaction!");
    }

    @Transactional(propagation = Propagation.REQUIRES_NEW)
    public void testRequiresNew() {
        throw new RuntimeException("Rollback this transaction!");
    }

    @Transactional(propagation = Propagation.NESTED)
    public void testNested() {
        throw new RuntimeException("Rollback this transaction!");
    }

    @Transactional(propagation = Propagation.MANDATORY)
    public void testMandatory() {
        throw new RuntimeException("Rollback this transaction!");
    }

    @Transactional(propagation = Propagation.NEVER)
    public void testNever() {
        throw new RuntimeException("Rollback this transaction!");
    }

    @Transactional(propagation = Propagation.SUPPORTS)
    public void testSupports() {
        throw new RuntimeException("Rollback this transaction!");
    }

    @Transactional(propagation = Propagation.NOT_SUPPORTED)
    public void testNotSupported() {
        throw new RuntimeException("Rollback this transaction!");
    }
}