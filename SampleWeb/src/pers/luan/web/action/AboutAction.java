package pers.luan.web.action;

import java.io.IOException;
import java.util.Properties;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import pers.luan.web.bean.ProjectBean;
import pers.luan.web.bean.ResumeBean;
import pers.luan.web.bean.form.ProjectFormBean;
import pers.luan.web.dao.AboutDAO;
import pers.luan.web.tool.FileIO;

@Controller
public class AboutAction {

	private Properties props;

	private AboutDAO dao;

	private String path;

	public AboutAction() {
		dao = new AboutDAO(System.getProperties());
	}

	@RequestMapping("/about")
	public String showAbout(Model model) throws IOException {
		return "about";
	}

	@RequestMapping(value = "about/{id}", method = RequestMethod.GET)
	public ModelAndView showTabbedPane(@PathVariable("id") String id,
					Model model) throws IOException {
		switch (id) {
		case "server":
			model.addAttribute("server", dao.fetchServerBean());
			break;
		case "system":
			model.addAttribute("system", dao.fetchSystemBean());
			break;
		case "project":
			path = getClass()
							.getResource("/pers/luan/web/file/project.properties")
							.toExternalForm();
			props = FileIO.readProperties(path.replace("file:", ""), false);
			ProjectBean projectBean = new ProjectBean();
			projectBean.setAuthor(props.getProperty("author"));
			projectBean.setEmail(props.getProperty("email"));
			projectBean.setPhone(props.getProperty("phone"));
			projectBean.setDescription(props.getProperty("description"));
			model.addAttribute("project", projectBean);
			break;
		case "resume":
			path = getClass().getResource("/pers/luan/web/file/resume.xml")
							.toExternalForm();
			props = FileIO.readProperties(path.replace("file:", ""), true);
			ResumeBean resumeBean = new ResumeBean();
			resumeBean.setName(props.getProperty("name"));
			resumeBean.setEmail(props.getProperty("email"));
			resumeBean.setPhone(props.getProperty("phone"));
			model.addAttribute("resume", resumeBean);
			break;
		}
		return new ModelAndView("part/about-" + id, "projectFormBean",
						new ProjectFormBean());
	}

}
