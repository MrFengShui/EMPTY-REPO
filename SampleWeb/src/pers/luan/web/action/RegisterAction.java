package pers.luan.web.action;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import pers.luan.web.bean.form.RegisterFormBean;
import pers.luan.web.bean.map.UserInfoBean;
import pers.luan.web.bean.map.UserSignBean;
import pers.luan.web.dao.RegisterDAO;
import pers.luan.web.db.SampleDB;
import pers.luan.web.tool.FileIO;

@Controller
public class RegisterAction {

	@RequestMapping(value = "/register", method = RequestMethod.GET)
	public ModelAndView doGetForm(Model model) {
		String path = getClass()
						.getResource("/pers/luan/web/file/agreement.txt")
						.toExternalForm();
		String content = FileIO.read(path.replace("file:", ""));
		model.addAttribute("contract", content);

		List<String> genderList = new ArrayList<>();
		genderList.add("Male");
		genderList.add("Female");
		genderList.add("None");
		model.addAttribute("genders", genderList);

		List<String> nationList = new ArrayList<>();
		nationList.add("Australia");
		nationList.add("China");
		nationList.add("France");
		nationList.add("Germany");
		nationList.add("Italy");
		nationList.add("Russia");
		nationList.add("Spain");
		nationList.add("United Kingdom");
		nationList.add("United States");
		model.addAttribute("nations", nationList);
		return new ModelAndView("register", "registerBean",
						new RegisterFormBean());
	}

	@RequestMapping(value = "/register", method = RequestMethod.POST)
	public String doPostForm(
					@ModelAttribute("registerBean") RegisterFormBean bean,
					ModelMap map) {
		RegisterDAO registerDAO = new RegisterDAO(SampleDB.fetchSQLSession());

		if (bean.getAgree()) {
			if (validForm(bean)) {
				return "redirect:register";
			}

			if (bean.getPassword().equals(bean.getConfirmPassword())) {
				UserInfoBean infoBean = new UserInfoBean();
				infoBean.setFirstname(bean.getFirstname());
				infoBean.setLastname(bean.getLastname());
				infoBean.setGender(bean.getGender().equals("Male") ? 1 : 0);
				infoBean.setEmail(bean.getEmail());
				infoBean.setNation(bean.getNation());
				infoBean.setDateOfBirth(bean.getDateOfBirth());

				UserSignBean signBean = new UserSignBean();
				signBean.setUsername(bean.getUsername());
				signBean.setPassword(bean.getPassword());

				if (registerDAO.isDone(infoBean, signBean)) {
					return "redirect:login";
				}
			}
		}

		return "redirect:register";
	}
	
	private boolean validForm(RegisterFormBean bean) {
		return bean.getFirstname().equals(null)
						&& bean.getLastname().equals(null)
						&& bean.getGender().equals(null)
						&& bean.getEmail().equals(null)
						&& bean.getDateOfBirth().equals(null)
						&& bean.getUsername().equals(null)
						&& bean.getPassword().equals(null)
						&& bean.getConfirmPassword().equals(null);
	}

}
