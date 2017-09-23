package pers.luan.web.test;

import java.io.File;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.OutputStream;
import java.io.Reader;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Map.Entry;

import javax.servlet.http.HttpServletRequest;

import java.util.Properties;
import java.util.Set;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.junit.Test;

import pers.luan.web.bean.tag.MenuTagBean;
import pers.luan.web.tool.FileIO;
import pers.luan.web.tool.MenuBuilder;
import pers.luan.web.tool.TreeBuilder;

public class UnitTest {

	@Test
	public void test() throws IOException {
		
	}

	@Test
	public void treeTest() {
		try {
			String path = getClass().getResource("/pers/luan/web/json/tree.json").toExternalForm().replace("file:", "");
			System.out.println(path);
			Reader reader = new FileReader(path);
			JSONParser parser = new JSONParser();
			JSONObject json = (JSONObject) parser.parse(reader);
			TreeBuilder builder = new TreeBuilder();
			
//			for (Object key : json.keySet()) {
//				TreeTagBean node = builder.buildTree(json, key.toString());
//				builder.printTree(node, "");
//			}
		} catch (ParseException | IOException e) {
			e.printStackTrace();
		}
	}
	
	@SuppressWarnings("unchecked")
	@Test
	public void menuTest() {
		try {
			String path = getClass().getResource("/pers/luan/web/json/menu.json").toExternalForm().replace("file:", "");
			System.out.println(path);
			Reader reader = new FileReader(path);
			JSONParser parser = new JSONParser();
			JSONObject json = (JSONObject) parser.parse(reader);
			MenuBuilder builder = new MenuBuilder();
			Set<Entry<Object, Object>> set = json.entrySet();
			List<MenuTagBean> list = new ArrayList<>();
//			builder.buildMenu((JSONObject) json.get("menu_1"), list);
			for (Entry<Object, Object> entry : set) {
				JSONObject object = (JSONObject) entry.getValue();
				builder.buildMenu(object, list);
			}
			MenuBuilder.printMenu(list);
		} catch (ParseException | IOException e) {
			e.printStackTrace();
		}
	}
	
	@Test
	public void propertiesTest() throws IOException {
		String path = getClass()
						.getResource("/pers/luan/web/file/project.properties")
						.toExternalForm();
		Properties props = FileIO.readProperties(path.replace("file:", ""),
						false);
		OutputStream os = new FileOutputStream("/home/MrFengShui/test.xml");
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd EEEE HH:mm:ss", Locale.getDefault());
//		props.storeToXML(os, "Modified By " + format.format(Calendar.getInstance().getTime()));
	}
	
	@Test
	public void systemTest() {
		Properties props = System.getProperties();
		
		for (Entry<Object, Object> entry : props.entrySet()) {
//			System.out.println(String.format(Locale.getDefault(), "KEY=%s\tVALUE=%s\n", entry.getKey(), entry.getValue()));
		}
	}
	
}