package com.pollen.pollenweb.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.pollen.pollenweb.entity.Users;
import com.pollen.pollenweb.exception.PwException;
import com.pollen.pollenweb.form.UserLoginForm;
import com.pollen.pollenweb.form.UserRegisterForm;
import com.pollen.pollenweb.mapper.UsersMapper;
import com.pollen.pollenweb.result.ResponseEnum;
import com.pollen.pollenweb.service.UsersService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.pollen.pollenweb.utils.MD5Util;
import com.pollen.pollenweb.utils.RegexValidateUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author yyq
 * @since 2022-01-16
 */
@Service
@Slf4j
public class UsersServiceImpl extends ServiceImpl<UsersMapper, Users> implements UsersService {

    @Autowired
    private UsersMapper usersMapper;

    @Override
    public Users register(UserRegisterForm userRegisterForm) {
        //用户名是否可用
        QueryWrapper<Users> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("login_name",userRegisterForm.getLoginName());
        Users one = this.usersMapper.selectOne(queryWrapper);
        if(one!=null){
            log.info("【用户注册】用户名已存在");
            throw new PwException(ResponseEnum.USER_NAME_EXISTS);
        }

        //格式校验
        if(RegexValidateUtil.checkEmail(userRegisterForm.getEmail())){
//            log.info("【格式错误】邮箱格式错误");
//            throw new PwException(ResponseEnum.EMAIL_ERROR);
        }

        //存储
        Users users = new Users();
        BeanUtils.copyProperties(userRegisterForm,users);
        users.setPassword(MD5Util.getSaltMD5(users.getPassword()));
        int insert = this.usersMapper.insert(users);
        if(insert != 1){
            log.info("【用户注册】添加用户失败");
            throw new PwException(ResponseEnum.USER_REGISTER_ERROR);
        }
        return users;
    }

    /**
     * 用户登录
     */
    @Override
    public Users login(UserLoginForm userLoginForm) {
        //判断用户名是否存在
        QueryWrapper<Users> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("login_name",userLoginForm.getLoginName());
        Users users = this.usersMapper.selectOne(queryWrapper);
        if(users==null){
            log.info("【用户登录】用户名不存在");
            throw new PwException(ResponseEnum.USERNAME_NOT_EXISTITS);
        }
        //判断密码是否正确
        if(!MD5Util.getSaltverifyMD5(userLoginForm.getPassword(),users.getPassword())){
            log.info("【用户登录】密码错误");
            throw new PwException(ResponseEnum.PASSWORD_ERROR);
        }

        users.setLastLogin(null);
        usersMapper.updateById(users);

        return users;
    }
}
