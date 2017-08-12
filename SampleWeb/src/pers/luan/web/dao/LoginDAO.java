package pers.luan.web.dao;

import org.apache.ibatis.session.SqlSession;

import pers.luan.web.bean.IndexBean;
import pers.luan.web.map.IndexMapper;

public class LoginDAO {

	private final SqlSession session;

	public LoginDAO(SqlSession session) {
		this.session = session;
	}
	
	public boolean isValid(IndexBean bean) {
		IndexMapper mapper = session.getMapper(IndexMapper.class);
		IndexBean mapperBean = mapper.findUserInfo(bean.getUsername());
		
		if (mapperBean != null) {
			return mapperBean.getUsername().equals(bean.getUsername()) && mapperBean.getPassword().equals(bean.getPassword());
		}
		
		return false;
	}
	
}
