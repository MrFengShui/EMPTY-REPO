package pers.luan.web.action;

import java.io.IOException;
import java.util.Properties;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
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
	
	private String path;
	
	@RequestMapping(value = "/about", method = RequestMethod.GET)
	public ModelAndView doGetForm(Model model) throws IOException {
		AboutDAO dao = new AboutDAO(System.getProperties());
		model.addAttribute("server", dao.fetchServerBean());
		model.addAttribute("system", dao.fetchSystemBean());

		path = getClass()
						.getResource("/pers/luan/web/file/project.properties")
						.toExternalForm();
		props = FileIO.readProperties(path.replace("file:", ""),
						false);
		ProjectBean projectBean = new ProjectBean();
		projectBean.setAuthor(props.getProperty("author"));
		projectBean.setEmail(props.getProperty("email"));
		projectBean.setPhone(props.getProperty("phone"));
		projectBean.setDescription(props.getProperty("description"));
		model.addAttribute("project", projectBean);
		
		path = getClass()
						.getResource("/pers/luan/web/file/resume.xml")
						.toExternalForm();
		props = FileIO.readProperties(path.replace("file:", ""),
						true);
		ResumeBean resumeBean = new ResumeBean();
		resumeBean.setName(props.getProperty("name"));
		resumeBean.setEmail(props.getProperty("email"));
		resumeBean.setPhone(props.getProperty("phone"));
		model.addAttribute("resume", resumeBean);
		return new ModelAndView("about", "projectFormBean", new ProjectFormBean());
	}
	
	@RequestMapping(value = "/about", method = RequestMethod.POST)
	public void doPostForm(@ModelAttribute("projectFormBean") ProjectFormBean bean,
					ModelMap map) {
		
	}
	
}
