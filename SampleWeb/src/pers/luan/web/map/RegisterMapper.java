package pers.luan.web.map;

import java.util.List;

import pers.luan.web.bean.map.UserInfoBean;
import pers.luan.web.bean.map.UserSignBean;

public interface RegisterMapper {

	public boolean addUserInfo(UserInfoBean bean);
	public boolean addUserSign(UserSignBean bean);
	public List<UserSignBean> checkUserInfo(String username);
	
}
