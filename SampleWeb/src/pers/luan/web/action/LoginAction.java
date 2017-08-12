package pers.luan.web.action;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import pers.luan.web.bean.IndexBean;
import pers.luan.web.dao.LoginDAO;
import pers.luan.web.db.SampleDB;

@Controller
public class LoginAction {
	
	@RequestMapping(value="/index", method=RequestMethod.GET)
	public ModelAndView getIndex(Model model) {
		IndexBean bean = new IndexBean();
		return new ModelAndView("index", "indexBean", bean);
	}
	
	@RequestMapping(value="/index", method=RequestMethod.POST)
	public String postIndex(@ModelAttribute("indexBean")IndexBean bean, Model model, ModelMap map) {
		LoginDAO loginDAO = new LoginDAO(SampleDB.fetchSQLSession());
		
		if (loginDAO.isValid(bean)) {
			String value = bean.getUsername();
			
			try {
				MessageDigest md = MessageDigest.getInstance("MD5");
				md.update(value.getBytes());
				value = new BigInteger(1, md.digest()).toString(16);
			} catch (NoSuchAlgorithmException e) {
				e.printStackTrace();
			}
			
			map.addAttribute("success", value);
			return "redirect:main";
		}

		return "index";
	}
	
	@RequestMapping(value="/main")
	public void main(@RequestParam(name="success", required=true) String username) {}
	
}
