package com.example.projectmanagementapp.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "user_accounts")
public class UserAccount {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "user_accounts_seq")
	private long userId;

	@Column(name = "username")
	private String userName;

	private String email;
	private String password;
	private boolean enabled = true;

	public UserAccount() {
	}

	long getUserId() {
		return userId;
	}

	void setUserId(long userId) {
		this.userId = userId;
	}

	String getUserName() {
		return userName;
	}

	void setUserName(String userName) {
		this.userName = userName;
	}

	String getEmail() {
		return email;
	}

	void setEmail(String email) {
		this.email = email;
	}

	String getPassword() {
		return password;
	}

	void setPassword(String password) {
		this.password = password;
	}

	boolean isEnabled() {
		return enabled;
	}

	void setEnabled(boolean enabled) {
		this.enabled = enabled;
	}
}
