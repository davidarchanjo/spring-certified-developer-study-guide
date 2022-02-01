package io.davidarchanjo;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.Map;

@Controller
@RequestMapping("hello")
public class HelloController {

	@GetMapping("spanish")
	public String passParametersWithModel(
		@RequestParam(name="name", defaultValue="World") String name,
		Model model
	) {
		Map<String, String> map = Map.of("welcomeMessage", "Buen Día");
		model.addAttribute("name", name)
			 .mergeAttributes(map);
		return "hello";
	}

	@GetMapping("german")
	public String passParametersWithModelMap(
		@RequestParam(name="name", defaultValue="World") String name,
		ModelMap map
	) {
		map.addAttribute("welcomeMessage", "Guten Morgen")
		   .addAttribute("name", name);
		return "hello";
	}

	@GetMapping("japanese")
	public ModelAndView passParametersWithModelAndView(
		@RequestParam(name="name", defaultValue="World") String name
	) {
		return new ModelAndView("hello")
			.addObject("welcomeMessage", "おはようございます")
			.addObject("name", name);
	}

}