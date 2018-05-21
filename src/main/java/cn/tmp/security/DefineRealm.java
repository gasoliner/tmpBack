package cn.tmp.security;

import cn.tmp.po.User;
import cn.tmp.service.RoleService;
import cn.tmp.service.UserService;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.HashSet;
import java.util.Set;

public class DefineRealm extends AuthorizingRealm {

    @Autowired
    UserService userService;
    @Autowired
    RoleService roleService;

    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        System.out.println("授权.");
        Integer username = (Integer) principalCollection.getPrimaryPrincipal();
        SimpleAuthorizationInfo authorizationInfo = new SimpleAuthorizationInfo();
        User user = userService.selectByPrimaryKey(username);
        Set<String> roleSet = new HashSet<>();
        roleSet.add(user.getRid().toString());

        authorizationInfo.setRoles(roleSet);
        return authorizationInfo;
    }

    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
        System.out.println("登录.");
        String username = (String) authenticationToken.getPrincipal();
        User user = userService.selectByPrimaryKey(Integer.valueOf(username));
        if(user == null) {
            throw new UnknownAccountException();//没找到帐号
        }
        AuthenticationInfo authenticationInfo = new SimpleAuthenticationInfo(
                user.getUid(),
                user.getPassword(),
                getName()
        );
        return authenticationInfo;
    }
}
