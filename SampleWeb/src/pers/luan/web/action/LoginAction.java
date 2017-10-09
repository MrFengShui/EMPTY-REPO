package pers.luan.web.action;

import java.io.FileReader;
import java.io.IOException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.text.DateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

import javax.xml.bind.DatatypeConverter;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import pers.luan.web.bean.form.LoginFormBean;
import pers.luan.web.dao.LoginDAO;
import pers.luan.web.db.SampleDB;
import pers.luan.web.tool.JSONTool;

@Controller
public class LoginAction {

	private FileReader reader;
	
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
					ModelMap map) {
		map.addAttribute("username", name);
		fillMenu(map);
		fillTree(map);
		return "index";
	}
	
	private void fillMenu(final ModelMap map) {
		try {
			String path = getClass().getResource("/pers/luan/web/json/menu.json")
							.toExternalForm().replace("file:", "");
			reader = new FileReader(path);
			JSONParser parser = new JSONParser();
			JSONArray json = (JSONArray) parser.parse(reader);
			map.addAttribute("menu_json", json.toJSONString().replaceAll("\"", "'"));
		} catch (IOException | ParseException e) {
			e.printStackTrace();
		} finally {
			if (reader != null) {
				try {
					reader.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}
	
	private void fillTree(final ModelMap map) {
		try {
			String path = getClass().getResource("/pers/luan/web/json/tree.json")
							.toExternalForm().replace("file:", "");
			reader = new FileReader(path);
			JSONParser parser = new JSONParser();
			JSONArray json = (JSONArray) parser.parse(reader);
			map.addAttribute("tree_json", json.toJSONString().replaceAll("\"", "'"));
			
			int size = 0;
			
			for (int i = 0; i < json.size(); i ++) {
				JSONObject item = (JSONObject) json.get(i);
				size = Math.max(size, JSONTool.measure(item, 0, ""));
			}
			
			map.addAttribute("size", size);
		} catch (IOException | ParseException e) {
			e.printStackTrace();
		} finally {
			if (reader != null) {
				try {
					reader.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}

}
