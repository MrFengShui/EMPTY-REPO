package prog.web.java.ctrl;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class EmailController {

	@RequestMapping(value="/studio/email.do")
	public ModelAndView showEmailPage() {
		return new ModelAndView("email");
	}
	
}
