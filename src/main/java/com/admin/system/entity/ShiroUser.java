package com.admin.system.entity;

import java.io.Serializable;
import java.util.List;

public class ShiroUser implements Serializable {

	private static final long serialVersionUID = -1373760761780840081L;

	public Long id;
	public String loginName;
	public String name;
	private List<String> roles;
	private List<String> permission;

	public ShiroUser() {
	}

	public ShiroUser(Long id, String loginName) {
		this.id = id;
		this.loginName = loginName;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getLoginName() {
		return loginName;
	}

	public void setLoginName(String loginName) {
		this.loginName = loginName;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<String> getRoles() {
		return roles;
	}

	public void setRoles(List<String> roles) {
		this.roles = roles;
	}

	public List<String> getPermission() {
		return permission;
	}

	public void setPermission(List<String> permission) {
		this.permission = permission;
	}

}
