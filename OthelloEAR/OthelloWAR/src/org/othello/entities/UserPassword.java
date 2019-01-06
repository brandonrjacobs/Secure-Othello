package org.othello.entities;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table
public class UserPassword {

	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer UserPwdId;
	
	
	private Integer FK_USERID;
	private String password;
	
	public UserPassword() {
		super();
	}

	public UserPassword(Integer userPwdId, Integer fK_USERID, String password) {
		super();
		UserPwdId = userPwdId;
		FK_USERID = fK_USERID;
		password = password;
	}

	public Integer getUserPwdId() {
		return UserPwdId;
	}

	public void setUserPwdId(Integer userPwdId) {
		UserPwdId = userPwdId;
	}

	public Integer getFK_USERID() {
		return FK_USERID;
	}

	public void setFK_USERID(Integer fK_USERID) {
		FK_USERID = fK_USERID;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
	
	
	
}
