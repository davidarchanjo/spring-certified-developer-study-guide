package io.davidarchanjo;

import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Data
@Component
public class TheClientBean {

    @Autowired
    private TheBean theBean;
}
