package pers.luan.web.bean;

public class TestBean {

	private String firstname, lastname;

	public String getFirstname() {
		return firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	@Override
	public String toString() {
		return "TestBean [firstname=" + firstname + ", lastname=" + lastname
						+ "]";
	}
	
}
