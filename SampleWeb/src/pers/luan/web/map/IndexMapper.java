package pers.luan.web.map;

import pers.luan.web.bean.IndexBean;

public interface IndexMapper {

	public IndexBean findUserInfo(String username);
	
}
