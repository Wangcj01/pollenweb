package com.pollen.pollenweb.configuration;

import at.pollux.thymeleaf.shiro.dialect.ShiroDialect;
import org.apache.shiro.authc.credential.HashedCredentialsMatcher;
import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.LinkedHashMap;
import java.util.Map;

/*
shiro的配置类
 */
@Configuration
public class ShiroConfig {
    /*
    创建ShiroFilterFactoryBean
     */
    @Bean
    public ShiroFilterFactoryBean getShiroFilterFactoryBean(@Qualifier("securityManager") DefaultWebSecurityManager securityManager){
        ShiroFilterFactoryBean bean =new ShiroFilterFactoryBean();
        //设置安全管理器
        bean.setSecurityManager(securityManager);
        //添加shiro的内置过滤器，完成登录的拦截
        /**
         anon:无需认证就可以登录
         authc:必须认证了才能登录
         user:必须拥有记住我功能才能使用
         perms:拥有对某个资源的权限才能使用
         role：拥有某个角色条件才能使用
         **/
        Map<String,String> filterMap =new LinkedHashMap<String,String>();
        filterMap.put("/login/*","anon");
        filterMap.put("/index/*","authc");
        filterMap.put("/*","anon");
        filterMap.put("/toLogin","anon");
        bean.setFilterChainDefinitionMap(filterMap);
//        //设置登录的请求
//        bean.setLoginUrl("/errorLogin");
        //也可以处理其他请求
        //处理未授权401的请求，跳转到controller层的noauth方法
        bean.setUnauthorizedUrl("/noauth");

        bean.setFilterChainDefinitionMap(filterMap);
        //不登录自动转向的页面
        bean.setLoginUrl("/detective");
        //登录后自动转向的页面
        bean.setSuccessUrl("/index");
        return bean;
    }


    /*
    创建DefaultWebSecurityManager
     */
    //关联realm
    @Bean(name="securityManager")
    public DefaultWebSecurityManager getdefaultWebSecurityManager(@Qualifier("userRealm") UserRealm userRealm){
        DefaultWebSecurityManager securityManager =new DefaultWebSecurityManager();
        //关联
        securityManager.setRealm(userRealm);
        return securityManager;
    }


    /*
    创建Realm
     */
    @Bean(name = "userRealm")
    public UserRealm userRealm(){
        UserRealm realm = new UserRealm();
        //设置加密的方式(一定要设置自定义的加密方式)
        realm.setCredentialsMatcher(hashedCredentialsMatcher());
        return realm;
    }

    //MD5加密
    @Bean("hashedCredentialsMatcher")
    public HashedCredentialsMatcher hashedCredentialsMatcher(){
        HashedCredentialsMatcher credentialsMatcher = new HashedCredentialsMatcher();
        //指定加密方式为MD5
        credentialsMatcher.setHashAlgorithmName("md5");
        //加密次数
        credentialsMatcher.setHashIterations(1024);
        //是否存储为16进制(一定要开启)
//        将setStoredCredentialsHexEncoded设置为true，则需要使用toHex()进行转换成字符串，默认使用的是toBase64()
        credentialsMatcher.setStoredCredentialsHexEncoded(true);
        return credentialsMatcher;
    }

    //thymeleaf整合Shiro
    @Bean
    public ShiroDialect shiroDialect(){
        return new ShiroDialect();
    }
}
