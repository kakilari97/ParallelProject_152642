package com.capg.app.bean;

public class CustomerDetails {

	private String name;
	private int age;
	private String gender;
	private long phoneNo;	
	private long aadhar;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public long getPhoneNo() {
		return phoneNo;
	}
	public void setPhoneNo(long phoneNo) {
		this.phoneNo = phoneNo;
	}
	public long getAadhar() {
		return aadhar;
	}
	public void setAadhar(long aadhar) {
		this.aadhar = aadhar;
	}
	@Override
	public String toString() {
		return "CustomerDetails [name=" + name + ", age=" + age + ", gender=" + gender + ", phoneNo=" + phoneNo
				+ ", aadhar=" + aadhar + "]";
	}
	
	
}
