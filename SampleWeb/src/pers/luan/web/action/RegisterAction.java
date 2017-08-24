package pers.luan.web.action;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.text.DateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import javax.xml.bind.DatatypeConverter;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import pers.luan.web.bean.LoginFormBean;
import pers.luan.web.bean.RegisterFormBean;
import pers.luan.web.bean.TreeNodeBean;
import pers.luan.web.dao.LoginDAO;
import pers.luan.web.db.SampleDB;
import pers.luan.web.tool.FileIO;
import pers.luan.web.tool.TreeBuilder;

@Controller
public class RegisterAction {

	private String name;

	@RequestMapping(value = "/register", method = RequestMethod.GET)
	public ModelAndView doGetForm(Model model) {
		String path = getClass().getResource("/pers/luan/web/file/agreement.txt").toExternalForm();
		String content = FileIO.read(path.replace("file:", ""));
		model.addAttribute("contract", content);
		
		List<String> genderList = new ArrayList<>();
		genderList.add("Male");
		genderList.add("Female");
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
		return new ModelAndView("register", "registerBean", new RegisterFormBean());
	}

	@RequestMapping(value = "/register", method = RequestMethod.POST)
	public String doPostForm(@ModelAttribute("registerBean") RegisterFormBean bean, ModelMap map) {
//		LoginDAO loginDAO = new LoginDAO(SampleDB.fetchSQLSession());
//
//		if (loginDAO.isValid(bean)) {
//			String value = bean.getUsername();
//			name = value;
//
//			try {
//				DateFormat format = DateFormat.getDateTimeInstance(
//								DateFormat.MEDIUM, DateFormat.MEDIUM);
//				Date date = Calendar.getInstance(Locale.getDefault()).getTime();
//				value += " login at " + format.format(date);
//				MessageDigest md = MessageDigest.getInstance("MD5");
//				md.update(value.getBytes());
//				value = DatatypeConverter.printHexBinary(md.digest())
//								.toLowerCase();
//			} catch (NoSuchAlgorithmException e) {
//				e.printStackTrace();
//			}
//
//			map.addAttribute("success", value);
//			return "redirect:main";
//		}
//
		return "register";
	}

//	@RequestMapping(value = "/main")
//	public String doRedirect(
//					@RequestParam(name = "success",
//									required = true) String value,
//					Model model) {
//		model.addAttribute("username", name);
//
//		String path = getClass().getResource("/pers/luan/web/cfg/list.json")
//						.toExternalForm().replace("file:", "");
//		TreeBuilder builder = new TreeBuilder();
//		List<TreeNodeBean> list = builder.parse(path);
//		model.addAttribute("treelist", list);
//		return "main";
//	}

}
