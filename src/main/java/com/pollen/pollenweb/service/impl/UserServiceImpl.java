package com.pollen.pollenweb.service.impl;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.pollen.pollenweb.entity.User;
import com.pollen.pollenweb.exception.PwException;
import com.pollen.pollenweb.mapper.UserMapper;
import com.pollen.pollenweb.result.ResponseEnum;
import com.pollen.pollenweb.service.IUserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.ResponseBody;

@Service
@Slf4j
public  class UserServiceImpl extends ServiceImpl<UserMapper, User> implements IUserService {

    @Autowired
    private UserMapper userMapper;

    @Override
    public User queryUserByUsername(User user) {
        QueryWrapper<User> wrapper=new QueryWrapper<>();
        wrapper.eq("user_name",user.getUser_name());
        return userMapper.selectOne(wrapper);
    }

    @Override
    public User queryUserByLoginname(User user) {
        QueryWrapper<User> wrapper=new QueryWrapper<>();
        wrapper.eq("login_name",user.getLogin_name());
        return userMapper.selectOne(wrapper);
    }

    @Override
    public int addUser(User user){
        if(queryUserByLoginname(user)!=null){
            log.info("【code:1004 msg:用户名已存在】");
            return 2;
        }else{
            return userMapper.insert(user);
        }

    }

    @Override
    public int editUser(User user) {
        return userMapper.updateById(user);
    }

}
