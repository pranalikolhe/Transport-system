package com.bean;

import java.io.Serializable;
import java.util.Date;

@SuppressWarnings("serial")
public class ManagerBean implements Serializable {
private String branch;
private String username;
private String password;
private Date date_of_joining;
private Date date_of_birth;
private String salary;
public ManagerBean() {
	super();
}
public String getBranch() {
	return branch;
}
public void setBranch(String branch) {
	this.branch = branch;
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
public Date getDate_of_joining() {
	return date_of_joining;
}
public void setDate_of_joining(Date date_of_joining) {
	this.date_of_joining = date_of_joining;
}
public Date getDate_of_birth() {
	return date_of_birth;
}
public void setDate_of_birth(Date date_of_birth) {
	this.date_of_birth = date_of_birth;
}
@Override
public String toString() {
	return "ManagerBean [branch=" + branch + ", username=" + username + ", password=" + password + ", date_of_joining="
			+ date_of_joining + ", date_of_birth=" + date_of_birth + "]";
}
public String getSalary() {
	return salary;
}
public void setSalary(String salary) {
	this.salary = salary;
}



}
