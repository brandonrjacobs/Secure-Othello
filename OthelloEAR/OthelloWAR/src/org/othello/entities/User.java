package org.othello.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table
public class User {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
//	@GeneratedValue
	private Integer UserId;
	private String firstName;
	//private String middleName;
	private String lastName;
	private String emailAddr;
	private String password;
	private String loginId;
	
	
	
	public User() {
		super();
	}



	public User(Integer userId, String firstName, String middleName, String lastName, String emailAddress,
			String password, String loginId) {
		super();
		UserId = userId;
		this.firstName = firstName;
	//	this.middleName = middleName;
		this.lastName = lastName;
		this.emailAddr = emailAddress;
		this.password = password;
		this.loginId = loginId;
	}



	public Integer getUserId() {
		return UserId;
	}



	public void setUserId(Integer userId) {
		UserId = userId;
	}



	public String getFirstName() {
		return firstName;
	}



	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}



//	public String getMiddleName() {
//		return middleName;
//	}
//
//
//
//	public void setMiddleName(String middleName) {
//		this.middleName = middleName;
//	}



	public String getLastName() {
		return lastName;
	}



	public void setLastName(String lastName) {
		this.lastName = lastName;
	}



	public String getEmailAddress() {
		return emailAddr;
	}



	public void setEmailAddress(String emailAddress) {
		this.emailAddr = emailAddress;
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

	
	
	

}
