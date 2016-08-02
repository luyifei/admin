package com.admin.system.service;

import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.crypto.hash.SimpleHash;
import org.springframework.stereotype.Service;

import com.admin.dao.DaoSupport;
import com.admin.system.entity.SimpleAuthToken;
import com.admin.system.entity.User;

@Service("newUserService")
public class UserService {
	@Resource(name = "daoSupport")
	private DaoSupport dao;

	public void authToken(SimpleAuthToken token) throws AuthenticationException {
		String shaPassword = new SimpleHash("SHA-1", token.getUserName(), token.getPassword()).toString();
		Map<String, String> param = new HashMap<>();
		param.put("userName", token.getUserName());
		param.put("password", shaPassword);
		User user = (User) dao.findForObject("UserMapper.authUser", param);
		if (user == null) {
			throw new UnknownAccountException();
		}
	}
}
