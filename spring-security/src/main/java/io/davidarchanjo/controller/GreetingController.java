package io.davidarchanjo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("api/greetings")
public class GreetingController {

	@GetMapping
	public String greeting(
		@RequestParam(name="name", defaultValue="World") String name, 
		Model model
	) {
		model.addAttribute("name", name);
		return "greeting";
	}

}