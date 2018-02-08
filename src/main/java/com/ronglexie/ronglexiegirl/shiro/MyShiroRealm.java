package com.ronglexie.ronglexiegirl.shiro;

import com.ronglexie.ronglexiegirl.entity.Permission;
import com.ronglexie.ronglexiegirl.entity.Role;
import com.ronglexie.ronglexiegirl.entity.User;
import com.ronglexie.ronglexiegirl.service.UserService;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.util.ByteSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @author ronglexie
 * @version 2018-2-8
 */
@Component
public class MyShiroRealm extends AuthorizingRealm {

	@Autowired
	private UserService userService;

	@Override
	protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
		System.out.println("权限配置-->MyShiroRealm.doGetAuthorizationInfo()");
		SimpleAuthorizationInfo authorizationInfo = new SimpleAuthorizationInfo();
		User User  = (User)principalCollection.getPrimaryPrincipal();
		for(Role role:User.getRoleList()){
			authorizationInfo.addRole(role.getRole());
			for(Permission p:role.getPermissions()){
				authorizationInfo.addStringPermission(p.getPermission());
			}
		}
		return authorizationInfo;
	}

	@Override
	protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
		System.out.println("MyShiroRealm.doGetAuthenticationInfo()");
		//获取用户的输入的账号.
		String username = (String)authenticationToken.getPrincipal();
		System.out.println(authenticationToken.getCredentials());
		//通过username从数据库中查找 User对象，如果找到，没找到.
		//实际项目中，这里可以根据实际情况做缓存，如果不做，Shiro自己也是有时间间隔机制，2分钟内不会重复执行该方法
		User user = userService.findByUsername(username);
		System.out.println("----->>user="+user);
		if(user == null){
			return null;
		}
		SimpleAuthenticationInfo authenticationInfo = new SimpleAuthenticationInfo(
				user, //用户名
				user.getPassword(), //密码
				ByteSource.Util.bytes(user.getCredentialsSalt()),//salt=username+salt
				getName()  //realm name
		);
		return authenticationInfo;
	}
}
