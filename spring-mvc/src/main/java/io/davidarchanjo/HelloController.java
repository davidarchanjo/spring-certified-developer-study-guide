package io.davidarchanjo;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("hello")
public class HelloController {

    @GetMapping("v1")
    public String helloV1(@RequestParam String name, Model model) {
        User user = new User(name);
        model.addAttribute("user", user);
        model.addAttribute("bkg", "yellow");
        model.addAttribute("title", "Spring MVC :: Model");
        return "greeting";
    }

    @GetMapping("v2")
    public String helloV2(@RequestParam String name, ModelMap modelMap) {
        User user = new User(name);
        modelMap.addAttribute("user", user);
        modelMap.addAttribute("bkg", "green");
        modelMap.addAttribute("title", "Spring MVC :: ModelMap");
        return "greeting";
    }

    @GetMapping("v3")
    public ModelAndView helloV3(@RequestParam String name) {
        ModelAndView modelAndView = new ModelAndView("greeting");
        User user = new User(name);
        modelAndView.addObject("user", user);
        modelAndView.addObject("bkg", "blue");
        modelAndView.addObject("title", "Spring MVC :: ModelAndView");
        return modelAndView;
    }

    @GetMapping("v4")
    public String helloV4(@ModelAttribute/* ("user") */ User user, Model model) {
        model.addAttribute("user", user);
        model.addAttribute("bkg", "red");
        model.addAttribute("title", "Spring MVC :: ModelAttribute");
        return "greeting";
    }
}
