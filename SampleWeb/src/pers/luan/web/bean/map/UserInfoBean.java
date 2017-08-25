package pers.luan.web.bean.map;

import java.util.Date;

public class UserInfoBean {

	private Date dateOfBirth;
	
	private String firstname, lastname;
	private String email, nation;	
	private Integer ID, gender;
	
	public Integer getID() {
		return ID;
	}
	
	public void setID(Integer id) {
		this.ID = id;
	}
	
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
	
	public Integer getGender() {
		return gender;
	}
	
	public void setGender(Integer gender) {
		this.gender = gender;
	}
	
	public String getEmail() {
		return email;
	}
	
	public void setEmail(String email) {
		this.email = email;
	}
	
	public String getNation() {
		return nation;
	}
	
	public void setNation(String nation) {
		this.nation = nation;
	}
	
	public Date getDateOfBirth() {
		return dateOfBirth;
	}
	
	public void setDateOfBirth(Date dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}

	@Override
	public String toString() {
		return "UserInfoBean [ID=" + ID + ", firstname=" + firstname
						+ ", lastname=" + lastname + ", gender=" + gender
						+ ", email=" + email + ", nation=" + nation
						+ ", dateOfBirth=" + dateOfBirth + "]";
	}
	
}
