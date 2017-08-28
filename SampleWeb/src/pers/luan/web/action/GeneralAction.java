package pers.luan.web.action;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class GeneralAction {

	
	
	@RequestMapping("/")
	public String initial() {
		return "redirect:login";
	}

	@RequestMapping("/test")
	public String test() {
		return "test";
	}

//	@RequestMapping("/about")
//	public String about(Model model) {
//		AboutDAO dao = new AboutDAO(System.getProperties());
//		model.addAttribute("server", dao.fetchServerBean());
//		model.addAttribute("system", dao.fetchSystemBean());
//
//		path = getClass()
//						.getResource("/pers/luan/web/file/project.properties")
//						.toExternalForm();
//		props = FileIO.readProperties(path.replace("file:", ""),
//						false);
//		ProjectBean projectBean = new ProjectBean();
//		projectBean.setAuthor(props.getProperty("author"));
//		projectBean.setEmail(props.getProperty("email"));
//		projectBean.setPhone(props.getProperty("phone"));
//		projectBean.setDescription(props.getProperty("description"));
//		model.addAttribute("project", projectBean);
//		
//		path = getClass()
//						.getResource("/pers/luan/web/file/resume.xml")
//						.toExternalForm();
//		props = FileIO.readProperties(path.replace("file:", ""),
//						true);
//		ResumeBean resumeBean = new ResumeBean();
//		resumeBean.setName(props.getProperty("name"));
//		resumeBean.setEmail(props.getProperty("email"));
//		resumeBean.setPhone(props.getProperty("phone"));
//		model.addAttribute("resume", resumeBean);
//		return "about";
//	}

}
