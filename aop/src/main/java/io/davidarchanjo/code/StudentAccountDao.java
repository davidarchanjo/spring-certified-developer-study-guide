package io.davidarchanjo.code;

import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class StudentAccountDao {
    public void newAccount() {
        System.out.println(getClass() + " : To open a new acount");
    }
}
