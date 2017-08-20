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

import pers.luan.web.bean.IndexBean;
import pers.luan.web.bean.MainListBean;
import pers.luan.web.dao.LoginDAO;
import pers.luan.web.db.SampleDB;

@Controller
public class LoginAction {
	
	private String name;
	private List<String> list;
	
	private MainListBean bean;
	
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
			name = value;
			
			try {
				DateFormat format = DateFormat.getDateTimeInstance(DateFormat.MEDIUM, DateFormat.MEDIUM);
				Date date = Calendar.getInstance(Locale.getDefault()).getTime();
				value += " login at " + format.format(date);
				MessageDigest md = MessageDigest.getInstance("MD5");
				md.update(value.getBytes());
				value = DatatypeConverter.printHexBinary(md.digest()).toLowerCase();
			} catch (NoSuchAlgorithmException e) {
				e.printStackTrace();
			}
			
			map.addAttribute("success", value);
			return "redirect:main";
		}

		return "index";
	}
	
	@RequestMapping(value="/main")
	public String main(@RequestParam(name="success", required=true) String username, Model model) {
		model.addAttribute("username", name);
		
		List<MainListBean> outerList = new ArrayList<>();	
		
		bean = new MainListBean();
		bean.setHeader("Sample Code");				
		list = new ArrayList<>();
		
		for (int i = 0; i < 8; i++) {
			list.add("Sample Code Item " + i);
		}
		
		bean.setList(list);		
		outerList.add(bean);
		
		bean = new MainListBean();
		bean.setHeader("Sample Tutorial");		
		list = new ArrayList<>();
		
		for (int i = 0; i < 8; i++) {
			list.add("Sample Tutorial Item " + i);
		}
		
		bean.setList(list);
		outerList.add(bean);
		
		model.addAttribute("outerlist", outerList);		
		return "main";
	}
	
}
