package com.admin.system.realm;

import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.admin.system.entity.ShiroUser;
import com.admin.system.entity.SimpleAuthToken;
import com.admin.system.service.UserService;

/**
 * @since 2016-7-21
 * @author sunny
 */
@Service
public class ShiroRealm extends AuthorizingRealm {

	@Autowired
	UserService userService;

	@Override
	public boolean supports(AuthenticationToken token) {
		if (token instanceof SimpleAuthToken) {
			return true;
		}
		return false;
	}

	/**
	 * 登录信息和用户信息验证
	 */
	@Override
	protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
		if (token instanceof SimpleAuthToken) {
			SimpleAuthToken simpleAuthToken = (SimpleAuthToken) token;
			// 去数据库查询数据进行验证
			userService.authToken(simpleAuthToken);
			//TODO 应该是getCredentials为null才报错的。
			SimpleAuthenticationInfo info = new SimpleAuthenticationInfo(simpleAuthToken.getPrincipal(),
					simpleAuthToken.getCredentials(), getName());
			return info;
		}
		return null;
	}

	/**
	 * 授权方法
	 */
	@Override
	protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection pc) {
		SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();
		ShiroUser shiroUser = (ShiroUser) pc.getPrimaryPrincipal();
		//info.addRole(role);
		//需要在登录验证的地方先添加权限到这个对象中
		info.addStringPermissions(shiroUser.getPermission());
		return null;
	}

}
