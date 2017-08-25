package pers.luan.web.bean.form;

public class LoginFormBean {

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
		return "LoginFormBean [username=" + username + ", password=" + password + "]";
	}
	
}
