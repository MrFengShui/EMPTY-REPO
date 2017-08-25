package pers.luan.web.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import pers.luan.web.bean.map.UserInfoBean;
import pers.luan.web.bean.map.UserSignBean;
import pers.luan.web.map.RegisterMapper;

public class RegisterDAO {

	private final SqlSession session;
	
	private int id;

	public RegisterDAO(SqlSession session) {
		this.session = session;
	}
	
	public boolean isDone(UserInfoBean infoBean, UserSignBean signBean) {
		RegisterMapper mapper = session.getMapper(RegisterMapper.class);
		List<UserSignBean> list = mapper.checkUserInfo(signBean.getUsername());
		
		if (list.isEmpty()) {
			id = 2017082400;
		} else {
			UserSignBean rsBean = list.get(list.size() - 1);
			id = rsBean.getID() + 1;
		}
		
		infoBean.setID(id);
		signBean.setID(id);
		return mapper.addUserInfo(infoBean) && mapper.addUserSign(signBean);
	}
	
}
