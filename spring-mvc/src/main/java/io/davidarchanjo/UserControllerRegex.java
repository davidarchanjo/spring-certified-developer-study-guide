package io.davidarchanjo;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.UUID;

@Slf4j
@Controller
@RequestMapping("/users")
public class UserControllerRegex {

    @RequestMapping("{id:[0-9]+}")
    public String handleAllUsersRequest (Model model, @PathVariable String id) {
        log.info("user id {}", id);
        model.addAttribute("name", "Number");
        return "greeting";
    }

    @RequestMapping("{id:[a-z]+}")
    public String handleAllUsersRequest2 (Model model, @PathVariable String id) {
        log.info("user id {}", id);
        model.addAttribute("name", "String");
        return "greeting";
    }

    @RequestMapping("{id:[0-9a-f]{8}-[0-9a-f]{4}-[1-5][0-9a-f]{3}-[89ab][0-9a-f]{3}-[0-9a-f]{12}}")
    public String handleAllUsersRequest3 (Model model, @PathVariable UUID id) {
        log.info("user id {}", id);
        model.addAttribute("name", "UUID");
        return "greeting";
    }
}