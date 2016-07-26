package com.blog.util;

import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.util.ByteSource;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * Created by Black on 2016/7/26.
 */
public class CustomRealm extends AuthorizingRealm{

    @Override
    public void setName(String name) {
        super.setName("customRealm");
    }

    //用于认证
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
        String userToken = (String) authenticationToken.getPrincipal();
        String password = "62981bcfc348c3073f9fe95b17158319";
        String salt1 = "陈淼";
        String salt2 = "edsdssaadc";
        SimpleAuthenticationInfo simpleAuthenticationInfo = new SimpleAuthenticationInfo(userToken, password, ByteSource.Util.bytes(salt1+salt2), this.getName());
        return simpleAuthenticationInfo;
    }

    //用于授权
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        String userToken = (String) principalCollection.getPrimaryPrincipal();
        List<String> permissions = new ArrayList<>();
        permissions.add("user:create");
        permissions.add("article:add");
        SimpleAuthorizationInfo simpleAuthorizationInfo = new SimpleAuthorizationInfo();
        simpleAuthorizationInfo.addStringPermissions(permissions);
        return simpleAuthorizationInfo;
    }
}
