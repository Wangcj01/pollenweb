package com.pollen.pollenweb.service;

import com.pollen.pollenweb.entity.Users;
import com.baomidou.mybatisplus.extension.service.IService;
import com.pollen.pollenweb.form.UserLoginForm;
import com.pollen.pollenweb.form.UserRegisterForm;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author admin
 * @since 2022-01-16
 */
public interface UsersService extends IService<Users> {
    public Users register(UserRegisterForm userRegisterForm);
    public Users login(UserLoginForm userLoginForm);
}
