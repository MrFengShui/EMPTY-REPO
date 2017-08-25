package pers.luan.web.bean.map;

public class UserSignBean {
	
	private String username, password;
	private Integer ID;
	
	public String getUsername() {
		return username;
	}
	
	public void setUsername(String username) {
		this.username = username;
	}
	
	public String getPassword() {
		return password;
	}
	
	public void setPassword(String password) {
		this.password = password;
	}

	public Integer getID() {
		return ID;
	}
	
	public void setID(Integer id) {
		this.ID = id;
	}

	@Override
	public String toString() {
		return "UserSignBean [username=" + username + ", password=" + password
						+ ", ID=" + ID + "]";
	}

}
