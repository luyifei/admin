package com.admin.system.entity;

import org.apache.shiro.authc.AuthenticationToken;

public class SimpleAuthToken implements AuthenticationToken {

	private static final long serialVersionUID = 7582235152421670110L;

	private String userName;
	private String password;
	private String googleAuthToken;

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

	public String getGoogleAuthToken() {
		return googleAuthToken;
	}

	public void setGoogleAuthToken(String googleAuthToken) {
		this.googleAuthToken = googleAuthToken;
	}

	public SimpleAuthToken(String userName, String password) {
		super();
		this.userName = userName;
		this.password = password;
	}

	@Override
	public Object getCredentials() {
		return this.password;
	}

	@Override
	public Object getPrincipal() {
		return this.userName;
	}

	@Override
	public String toString() {
		return "SimpleAuthToken [userName=" + userName + ", password=" + password + ", googleAuthToken="
				+ googleAuthToken + "]";
	}

}
