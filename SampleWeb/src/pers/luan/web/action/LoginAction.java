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

import pers.luan.web.bean.MenuItemBean;
import pers.luan.web.bean.TreeNodeBean;
import pers.luan.web.bean.form.LoginFormBean;
import pers.luan.web.dao.LoginDAO;
import pers.luan.web.db.SampleDB;
import pers.luan.web.tool.MenuBuilder;
import pers.luan.web.tool.TreeBuilder;

@Controller
public class LoginAction {

	private String name;

	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public ModelAndView doGetForm() {
		return new ModelAndView("login", "indexBean", new LoginFormBean());
	}

	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public String doPostForm(@ModelAttribute("indexBean") LoginFormBean bean, ModelMap map) {
		LoginDAO loginDAO = new LoginDAO(SampleDB.fetchSQLSession());

		if (loginDAO.isValid(bean)) {
			String value = bean.getUsername();
			name = value;

			try {
				DateFormat format = DateFormat.getDateTimeInstance(
								DateFormat.MEDIUM, DateFormat.MEDIUM);
				Date date = Calendar.getInstance(Locale.getDefault()).getTime();
				value += " login at " + format.format(date);
				MessageDigest md = MessageDigest.getInstance("MD5");
				md.update(value.getBytes());
				value = DatatypeConverter.printHexBinary(md.digest())
								.toLowerCase();
			} catch (NoSuchAlgorithmException e) {
				e.printStackTrace();
			}

			map.addAttribute("success", value);
			return "redirect:index";
		}

		return "login";
	}

	@RequestMapping(value = "/index")
	public String doRedirect(
					@RequestParam(name = "success",
									required = true) String value,
					Model model) {
		model.addAttribute("username", name);
		
		String path = getClass().getResource("/pers/luan/web/json/menu.json")
						.toExternalForm().replace("file:", "");
		MenuBuilder menuBuilder = new MenuBuilder();
		List<MenuItemBean> menuList = menuBuilder.parse(path);
		List<MenuItemBean> root = new ArrayList<>();
		
		for (int i = 0; i < menuList.size(); i ++) {
			MenuItemBean bean = menuList.get(i);
			
			if (bean.getType().equals("menu")) {
				root.add(bean);
			}
		}
		model.addAttribute("root", root);
		model.addAttribute("nodes", menuList);

		path = getClass().getResource("/pers/luan/web/json/tree.json")
						.toExternalForm().replace("file:", "");
		TreeBuilder treeBuilder = new TreeBuilder();
		List<TreeNodeBean> treeList = treeBuilder.parse(path);
		model.addAttribute("treelist", treeList);
		return "index";
	}

}
