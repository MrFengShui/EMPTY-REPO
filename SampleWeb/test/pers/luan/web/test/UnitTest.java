package pers.luan.web.test;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map.Entry;
import java.util.Set;

import org.apache.ibatis.session.SqlSession;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.junit.Test;

import pers.luan.web.bean.IndexBean;
import pers.luan.web.bean.MainBean;
import pers.luan.web.bean.SampleBean;
import pers.luan.web.db.SampleDB;
import pers.luan.web.map.IndexMapper;
import pers.luan.web.map.SampleMapper;
import pers.luan.web.tool.ProjectPath;

public class UnitTest {

	private SqlSession session;

	@Test
	public void test() throws IOException {
		System.out.println("Hello, Unit Test");
	}
	
	@Test
	public void pathTest() {
		ProjectPath progPath = new ProjectPath();
		String path = progPath.fetchPath();
		File file = new File(path, "WEB-INF/mybatis-config.xml");
		System.out.println("File Path: " + file.getAbsolutePath());
		System.out.println("File Exist: " + file.exists());
	}
	
	@Test
	public void mybatisTest() throws IOException {
		session = SampleDB.fetchSQLSession();
		SampleMapper mapper = session.getMapper(SampleMapper.class);
		List<SampleBean> list = mapper.findAllSamples();
		
		for (SampleBean item : list) {
			System.out.println(item.toString());
		}
		
		if (session != null) {
			session.close();
		}
	}
	
	@Test
	public void indexTest() {
		session = SampleDB.fetchSQLSession();
		IndexMapper mapper = session.getMapper(IndexMapper.class);
		IndexBean bean = mapper.findUserInfo("tester");
		
		if (bean.getUsername().equals("tester") && bean.getPassword().equals("123456")) {
			System.out.println("Success");
		} else {
			System.out.println("Failure");
		}
		
		if (session != null) {
			session.close();
		}
	}
	
	@Test
	public void jsonTest() {
		try {
			String path = getClass().getResource("/pers/luan/web/cfg/list.json").toExternalForm().replace("file:", "");
			System.out.println(path);
			Reader reader = new FileReader(path);
			JSONParser parser = new JSONParser();
			JSONObject json = (JSONObject) parser.parse(reader);
			
			for (Object key : json.keySet()) {
				JSONObject value = (JSONObject) json.get(key);
				String title = value.get("title").toString();
				String place = value.get("place").toString();
				JSONArray array = (JSONArray) value.get("list");
				List<MainBean.ItemBean> list = new ArrayList<>();
				
				for (int i = 0; i < array.size(); i ++) {
					JSONObject item = (JSONObject) array.get(i);
					MainBean.ItemBean itemBean = new MainBean.ItemBean();
					itemBean.setTitle(item.get("title").toString());
					itemBean.setPlace(item.get("place").toString());
					list.add(itemBean);
				}
				System.out.printf("%s %s\n", key, value);
				System.out.printf("Title: %s\nPlace: %s\nList: %s\n", title, place, array);
				MainBean mainBean = new MainBean();
				mainBean.setTitle(value.get("title").toString());
				mainBean.setPlace(value.get("place").toString());
				mainBean.setList(list);
				System.out.println(mainBean);
			}
		} catch (ParseException | IOException e) {
			e.printStackTrace();
		}
	}
	
}
