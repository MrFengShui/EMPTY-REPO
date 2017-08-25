package pers.luan.web.map;

import pers.luan.web.bean.map.UserSignBean;

public interface LoginMapper {

	public UserSignBean findUserInfo(String username);
	
}
