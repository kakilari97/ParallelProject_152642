package com.capg.app.bean;

public class CustomerDetails {

	private String consumerName;

	private int age;
	private String emailId;

	private String phoneNo;

	private String gender;
	

	public String getConsumerName() {
		return consumerName;
	}

	public void setConsumerName(String consumerName) {
		this.consumerName = consumerName;
	}

	

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getEmailId() {
		return emailId;
	}

	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}

	
	public String getPhoneNo() {
		return phoneNo;
	}

	public void setPhoneNo(String phoneNo) {
		this.phoneNo = phoneNo;
	}

	

	
	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	@Override
	public String toString() {
		return "CustomerDetails:\nconsumerName=" + consumerName + ",\\n age=" + age + ", \\nemailId=" + emailId + ",\\n phoneNo="
				+ phoneNo + ", \\ngender=" + gender ;
	}

	


}