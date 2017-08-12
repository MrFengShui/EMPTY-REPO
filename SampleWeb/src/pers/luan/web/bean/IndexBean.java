package pers.luan.web.bean;

public class IndexBean {

	private String username, password;

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

	@Override
	public String toString() {
		return "IndexBean [username=" + username + ", password=" + password + "]";
	}
	
}
