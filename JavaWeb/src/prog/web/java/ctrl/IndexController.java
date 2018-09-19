package prog.web.java.ctrl;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class IndexController {

	@RequestMapping(value="/")
	public ModelAndView redirectIndexPage() {
		return new ModelAndView("redirect:index.do");
	}
	
	@RequestMapping(value="/index.do")
	public ModelAndView showIndexPage() {
		return new ModelAndView("index");
	}
	
}
