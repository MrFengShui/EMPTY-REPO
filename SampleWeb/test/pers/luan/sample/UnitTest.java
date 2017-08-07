package pers.luan.sample;

import java.io.File;
import java.io.IOException;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.junit.Assert;
import org.junit.Test;

import pers.luan.sample.map.SampleMapper;

public class UnitTest {

	private SqlSession session;

	@Test
	public void test() throws IOException {
		System.out.println("Hello, Unit Test");
	}
	
	@Test
	public void pathTest() {
		String path = "pers/luan/sample/mybatis-config.xml";
		File file = new File(path);
		System.out.println(file.getAbsolutePath() + " " + file.exists());
	}
	
	@Test
	public void mybatisTest() throws IOException {
		session = SampleDB.fetchSQLSession();
		SampleMapper mapper = session.getMapper(SampleMapper.class);
		List<SampleModel> list = mapper.findAllSamples();
		
		for (SampleModel item : list) {
			System.out.println(item.toString());
		}
		
		if (session != null) {
			session.close();
		}
	}
	
}
