package pers.luan.web.db;

import java.io.IOException;
import java.io.Reader;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class SampleDB {

	private static Reader reader;
	private static SqlSessionFactory factory;
	private static SqlSessionFactoryBuilder builder;
	
	static {
		try {
			reader = Resources.getResourceAsReader("mybatis-config.xml");
			builder = new SqlSessionFactoryBuilder();
			factory = builder.build(reader);
		} catch (IOException e) {
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
	
	public static SqlSession fetchSQLSession() {
		return factory.openSession(true);
	}
	
}
