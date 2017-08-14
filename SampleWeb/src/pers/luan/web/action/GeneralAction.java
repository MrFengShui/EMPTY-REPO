package pers.luan.web.action;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import pers.luan.web.dao.AboutDAO;

@Controller
public class GeneralAction {

	@RequestMapping("/")
	public String initial() {
		return "redirect:index";
	}
	
	@RequestMapping("/index")
	public String index() {
		return "index";
	}
	
	@RequestMapping("/test")
	public String test() {
		return "test";
	}
	
	@RequestMapping("/about")
	public String about(Model model) {	
		AboutDAO dao = new AboutDAO(System.getProperties());
		model.addAttribute("rtbean", dao.fetchRTBean());
		model.addAttribute("vmbean", dao.fetchVMBean()[0]);
		model.addAttribute("specbean", dao.fetchVMBean()[1]);
		model.addAttribute("serverbean", dao.fetchServerBean());
		model.addAttribute("osbean", dao.fetchOSBean());
		model.addAttribute("userbean", dao.fetchUserBean());
		model.addAttribute("jarbean", dao.fetchJarBean());
		return "about";
	}
	
}
