package pers.luan.web.test;

import java.io.File;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.OutputStream;
import java.io.Reader;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.List;
import java.util.Locale;
import java.util.Map.Entry;
import java.util.Properties;

import org.apache.ibatis.session.SqlSession;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.junit.Test;

import pers.luan.web.bean.SampleBean;
import pers.luan.web.bean.TreeNodeBean;
import pers.luan.web.bean.map.UserSignBean;
import pers.luan.web.db.SampleDB;
import pers.luan.web.map.LoginMapper;
import pers.luan.web.map.SampleMapper;
import pers.luan.web.tool.FileIO;
import pers.luan.web.tool.ProjectPath;
import pers.luan.web.tool.TreeBuilder;

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
		LoginMapper mapper = session.getMapper(LoginMapper.class);
		UserSignBean bean = mapper.findUserInfo("tester");
		
		if (bean.getUsername().equals("nwwolf") && bean.getPassword().equals("123456")) {
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
			String path = getClass().getResource("/pers/luan/web/json/list.json").toExternalForm().replace("file:", "");
			System.out.println(path);
			Reader reader = new FileReader(path);
			JSONParser parser = new JSONParser();
			JSONObject json = (JSONObject) parser.parse(reader);
			TreeBuilder builder = new TreeBuilder();
			
			for (Object key : json.keySet()) {
				TreeNodeBean node = builder.buildTree(json, key.toString());
				builder.printTree(node, "");
			}
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
			System.out.println(String.format(Locale.getDefault(), "KEY=%s\tVALUE=%s\n", entry.getKey(), entry.getValue()));
		}
	}
	
}