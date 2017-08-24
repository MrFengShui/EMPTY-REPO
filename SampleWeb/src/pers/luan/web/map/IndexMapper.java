package pers.luan.web.map;

import pers.luan.web.bean.LoginFormBean;

public interface IndexMapper {

	public LoginFormBean findUserInfo(String username);
	
}
