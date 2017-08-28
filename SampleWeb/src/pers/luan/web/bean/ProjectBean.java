package pers.luan.web.bean;

public class ProjectBean {

	private String author, email, phone, description;

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String name) {
		this.author = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	@Override
	public String toString() {
		return "ProjectBean [author=" + author + ", email=" + email + ", phone="
						+ phone + ", description=" + description + "]";
	}
	
}
