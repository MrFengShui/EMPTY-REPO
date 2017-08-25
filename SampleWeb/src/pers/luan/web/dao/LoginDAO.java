package pers.luan.web.dao;

import org.apache.ibatis.session.SqlSession;

import pers.luan.web.bean.form.LoginFormBean;
import pers.luan.web.bean.map.UserSignBean;
import pers.luan.web.map.LoginMapper;

public class LoginDAO {

	private final SqlSession session;

	public LoginDAO(SqlSession session) {
		this.session = session;
	}
	
	public boolean isValid(LoginFormBean bean) {
		LoginMapper mapper = session.getMapper(LoginMapper.class);
		UserSignBean signBean = mapper.findUserInfo(bean.getUsername());
		
		if (signBean != null) {
			return signBean.getUsername().equals(bean.getUsername()) && signBean.getPassword().equals(bean.getPassword());
		}
		
		return false;
	}
	
}
