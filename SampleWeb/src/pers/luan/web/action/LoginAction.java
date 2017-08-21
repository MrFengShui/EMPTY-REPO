package pers.luan.web.action;

import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.text.DateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import javax.xml.bind.DatatypeConverter;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import pers.luan.web.bean.IndexBean;
import pers.luan.web.bean.MainBean;
import pers.luan.web.dao.LoginDAO;
import pers.luan.web.db.SampleDB;

@Controller
public class LoginAction {
	
	private String name;

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
		
		String path = getClass().getResource("/pers/luan/web/cfg/list.json").toExternalForm().replace("file:", "");
		List<MainBean> list = parse(path);			
		model.addAttribute("outerlist", list);			
		return "main";
	}
	
	private List<MainBean> parse(String path) {
		try {
			List<MainBean> mainList = new ArrayList<>();
			Reader reader = new FileReader(path);
			JSONParser parser = new JSONParser();
			JSONObject json = (JSONObject) parser.parse(reader);
			
			for (Object key : json.keySet()) {
				JSONObject value = (JSONObject) json.get(key);
				JSONArray array = (JSONArray) value.get("list");
				List<MainBean.ItemBean> itemList = new ArrayList<>();
				
				for (int i = 0; i < array.size(); i ++) {
					JSONObject item = (JSONObject) array.get(i);
					MainBean.ItemBean itemBean = new MainBean.ItemBean();
					itemBean.setTitle(item.get("title").toString());
					itemBean.setPlace(item.get("place").toString());
					itemList.add(itemBean);
				}
				
				MainBean mainBean = new MainBean();
				mainBean.setTitle(value.get("title").toString());
				mainBean.setPlace(value.get("place").toString());
				mainBean.setList(itemList);
				mainList.add(mainBean);
			}
			
			return mainList;
		} catch (IOException | ParseException e) {
			e.printStackTrace();
		}
		
		return null;
	}
	
}
