package org.othello.beans;

public class RegistrationBean {
	
	private String firstName;
	private String middleName;
	private String lastName;
	private String emailAddress;
	private String password;
	private String loginId;
	private int userid;
	
	
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getMiddleName() {
		return middleName;
	}
	public void setMiddleName(String middleName) {
		this.middleName = middleName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getEmailAddress() {
		return emailAddress;
	}
	public void setEmailAddress(String emailAddress) {
		this.emailAddress = emailAddress;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getLoginId() {
		return loginId;
	}
	public void setLoginId(String loginId) {
		this.loginId = loginId;
	}
	public int getUserid() {
		return userid;
	}
	public void setUserid(int userid) {
		this.userid = userid;
	}
	
	@Override
	public String toString() {
		return "RegistrationBean [firstName=" + firstName + ", middleName=" + middleName + ", lastName=" + lastName
				+ ", emailAddress=" + emailAddress + ", password=" + password + ", loginId=" + loginId + ", userid="
				+ userid + "]";
	}
	
	
	

}
