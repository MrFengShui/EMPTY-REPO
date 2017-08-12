package pers.luan.web.test;

import java.io.File;
import java.io.IOException;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import pers.luan.web.bean.IndexBean;
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
	
}
