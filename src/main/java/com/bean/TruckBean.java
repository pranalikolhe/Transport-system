package com.bean;

import java.io.Serializable;
import java.util.Date;

@SuppressWarnings("serial")
public class TruckBean implements Serializable{
	private String truck_Model;
	private String Truck_no;
	private String insurance;
	private String insurance_Company;
	private String owner;
	private String mobile;
	private String route_from;
	private String route_to;
	private String status;
	private Date Date_of_joining;
	public TruckBean() {
		super();
	}
	public String getTruck_Model() {
		return truck_Model;
	}
	public void setTruck_Model(String truck_Model) {
		this.truck_Model = truck_Model;
	}
	public String getTruck_no() {
		return Truck_no;
	}
	public void setTruck_no(String truck_no) {
		Truck_no = truck_no;
	}
	public String getInsurance() {
		return insurance;
	}
	public void setInsurance(String insurance) {
		this.insurance = insurance;
	}
	public String getInsurance_Company() {
		return insurance_Company;
	}
	public void setInsurance_Company(String insurance_Company) {
		this.insurance_Company = insurance_Company;
	}
	public String getOwner() {
		return owner;
	}
	public void setOwner(String owner) {
		this.owner = owner;
	}
	public String getMobile() {
		return mobile;
	}
	public void setMobile(String mobile) {
		this.mobile = mobile;
	}
	public String getRoute_from() {
		return route_from;
	}
	public void setRoute_from(String route_from) {
		this.route_from = route_from;
	}
	public String getRoute_to() {
		return route_to;
	}
	public void setRoute_to(String route_to) {
		this.route_to = route_to;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public Date getDate_of_joining() {
		return Date_of_joining;
	}
	public void setDate_of_joining(Date date_of_joining) {
		Date_of_joining = date_of_joining;
	}
	@Override
	public String toString() {
		return "TruckBean [truck_Model=" + truck_Model + ", Truck_no=" + Truck_no + ", insurance=" + insurance
				+ ", insurance_Company=" + insurance_Company + ", owner=" + owner + ", mobile=" + mobile
				+ ", route_from=" + route_from + ", route_to=" + route_to + ", status=" + status + ", Date_of_joining="
				+ Date_of_joining + "]";
	}
	

}
