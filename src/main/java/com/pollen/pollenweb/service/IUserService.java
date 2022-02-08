package com.pollen.pollenweb.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.pollen.pollenweb.entity.User;

/*
    用户表的Service接口
 */
public interface IUserService extends IService<User> {

    //根据用户名查询用户对象
    public User queryUserByUsername(User user);
    //根据账号查询用户对象
    public User queryUserByLoginname(User user);
    //新增一个用户信息
    public int addUser(User user);
    //修改用户信息
    public int editUser(User user);
}
