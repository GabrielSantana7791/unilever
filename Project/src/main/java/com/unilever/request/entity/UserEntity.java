package com.unilever.request.entity;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class UserEntity {
	
	@Id
	private int id;
	
	private String userName, password;

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public int getId() {
		return id;
	}
	
	

}
