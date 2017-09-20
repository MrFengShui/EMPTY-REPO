package pers.luan.web.action;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class GeneralAction {

	@RequestMapping("/")
	public String initial() {
		return "redirect:login";
	}

}
