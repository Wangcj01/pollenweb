package com.pollen.pollenweb.configuration;

import com.pollen.pollenweb.entity.User;
import com.pollen.pollenweb.mapper.UserMapper;
import com.pollen.pollenweb.service.IUserService;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Date;
import java.util.TimeZone;


//权限认证
public class UserRealm extends AuthorizingRealm {
    @Autowired
    private IUserService userService;

    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException{
        UsernamePasswordToken token=(UsernamePasswordToken) authenticationToken;
        String username=token.getUsername();
        User queryUser=new User();
        queryUser.setLogin_name(username);
        //根据用户名查询用户是否存在
        User user=userService.queryUserByLoginname(queryUser);
        if(user==null){
            return null;
        }
        user.setLast_login(new Date());
        userService.editUser(user);
        return new SimpleAuthenticationInfo(user,user.getPassword(),getName());

    }

    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
        return null;
    }
}
