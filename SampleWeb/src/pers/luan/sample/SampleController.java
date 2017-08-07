package pers.luan.sample;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class SampleController {
	
	@RequestMapping("/index")
	public String index() {
		return "index";
	}
	
	@RequestMapping("/test")
	public String test(Model model) {
		model.addAttribute("message", "Hello, Spring MVC");
		return "test";
	}
	
	@RequestMapping("/")
	public String initial() {
		return "redirect:index";
	}
	
}
