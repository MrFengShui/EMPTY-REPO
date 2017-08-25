package pers.luan.web.bean.form;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

public class RegisterFormBean {

	@DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
	private Date dateOfBirth;
	
	private String firstname, lastname;
	private String gender, email, nation;
	private String username, password, confirmPassword;
	private Boolean agree;

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

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public Date getDateOfBirth() {
		return dateOfBirth;
	}

	public void setDateOfBirth(Date dataOfBirth) {
		this.dateOfBirth = dataOfBirth;
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

	public String getConfirmPassword() {
		return confirmPassword;
	}

	public void setConfirmPassword(String confirmPassword) {
		this.confirmPassword = confirmPassword;
	}

	public Boolean getAgree() {
		return agree;
	}

	public void setAgree(Boolean agree) {
		this.agree = agree;
	}

	@Override
	public String toString() {
		return "RegisterFormBean [firstname=" + firstname + ", lastname="
						+ lastname + ", gender=" + gender + ", email=" + email
						+ ", nation=" + nation + ", dateOfBirth=" + dateOfBirth
						+ ", username=" + username + ", password=" + password
						+ ", confirmPassword=" + confirmPassword + ", agree="
						+ agree + "]";
	}
	
}
