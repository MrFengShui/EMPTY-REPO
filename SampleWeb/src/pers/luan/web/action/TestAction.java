package pers.luan.web.action;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class TestAction {

	@RequestMapping("/test")
	public String test(HttpServletRequest request, ModelMap map) {
		
		return "test";
	}

}
