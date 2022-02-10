//package com.pollen.pollenweb.configuration;
//
//import at.pollux.thymeleaf.shiro.dialect.ShiroDialect;
//import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
//import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//
//import java.util.LinkedHashMap;
//import java.util.Map;
//
//@Configuration
//public class ShiroFilterConfiguration {
//    //创建过滤工厂Bean
//    @Bean
//    public ShiroFilterFactoryBean shiroFilterFactoryBean(){
//        ShiroFilterFactoryBean shiroFilterFactoryBean=new ShiroFilterFactoryBean();
//        shiroFilterFactoryBean.setSecurityManager(setSecurityManager());
//
//        //shiro内置过滤器，实现权限相关的拦截器
//        //anon：无需登录即可访问
//        //authc：必须登录才可以访问
//        Map<String,String> filterMap=new LinkedHashMap<>();
////        filterMap.put("/static/**","anon");
////        filterMap.put("/login","anon");
////        filterMap.put("/toLogin","anon");
//        filterMap.put("/**","anon");
//
//        shiroFilterFactoryBean.setFilterChainDefinitionMap(filterMap);
//        //不登录自动转向的页面
////        shiroFilterFactoryBean.setLoginUrl("/detective");
//        //登录后自动转向的页面
////        shiroFilterFactoryBean.setSuccessUrl("/index");
//        return shiroFilterFactoryBean;
//    }
//
//    //权限管理
//    @Bean
//    public DefaultWebSecurityManager setSecurityManager(){
//        DefaultWebSecurityManager securityManager=new DefaultWebSecurityManager();
//        securityManager.setRealm(userRealm());
//        return securityManager;
//    }
//
//    //创建Realm，认证用
//    @Bean
//    public UserRealm userRealm(){
//        UserRealm userRealm=new UserRealm();
//        return  userRealm;
//    }
//
//    //thymeleaf整合Shiro
//    @Bean
//    public ShiroDialect shiroDialect(){
//        return new ShiroDialect();
//    }
//
//
//}
