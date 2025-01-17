package com.bean;

import java.io.Serializable;

@SuppressWarnings("serial")
public class Contact_usBean implements Serializable {
	private String name;
	private String email;
	private String phone;
	private String message;
	public Contact_usBean() {
		super();
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
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
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	@Override
	public String toString() {
		return "Contact_usBean [name=" + name + ", email=" + email + ", phone=" + phone + ", message=" + message + "]";
	}
	
}
