package io.davidarchanjo;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("hello")
public class HelloController {

    @GetMapping
    public String hello(@RequestParam String name, Model model) {
        User user = new User(name);
        model.addAttribute("user", user);
        return "greeting";
    }
}
