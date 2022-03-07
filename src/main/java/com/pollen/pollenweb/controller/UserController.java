package com.pollen.pollenweb.controller;

import com.pollen.pollenweb.exception.PwException;
import com.pollen.pollenweb.result.ResponseEnum;
import com.pollen.pollenweb.result.ResultMapUtil;
import com.pollen.pollenweb.entity.User;
import com.pollen.pollenweb.service.IUserService;
import lombok.extern.slf4j.Slf4j;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Date;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author yyq zz wcj
 * @since 2022-01-30
 */
@Controller
@Slf4j
public class UserController {
    @Autowired
    private IUserService userService;

    @RequestMapping("/errorLogin")
    public Integer errorLogin(){
        System.out.println("跳转错误界面");
        return null;
    }

    //判断用户登录是否成功
    //直接抛出给统一错误处理类解决
    @RequestMapping(value="/toLogin")
    @ResponseBody
    public Object toLogin(String username, String password){
        if(username==null||password==null){
            //统一错误处理 下同
            throw new PwException(ResponseEnum.USER_INFO_NULL);
        }
        Subject subject=SecurityUtils.getSubject();

        UsernamePasswordToken token=new UsernamePasswordToken(username,password);
        try{
            subject.login(token);
        }catch (UnknownAccountException e){
            throw new PwException(ResponseEnum.USERNAME_NOT_EXISTITS);
        }catch(IncorrectCredentialsException e){
            throw new PwException(ResponseEnum.PASSWORD_ERROR);
        }
        return ResultMapUtil.getHashMapLogin("验证成功","1");

    }

    @RequestMapping(value="/judge")
    @ResponseBody
    public boolean judge(){
        Subject subject=SecurityUtils.getSubject();
        return subject.isAuthenticated();
    }

    @RequestMapping(value="/UserAdd")
    @ResponseBody
    public Object UserAdd(User user){
        try{
            user.setCreated_time(new Date());
            int i = userService.addUser(user);
            return ResultMapUtil.getHashMapSave(i);
        } catch (Exception e){
            return ResultMapUtil.getHashMapException(e);
        }

    }

    @RequestMapping(value="/detective")
    public String detective(){return "/detective";}

    @RequestMapping(value ="/login")
    public String login(){
        return "/login";
    }
    /**
     * 退出登录
     */
    @RequestMapping(value = "/logout")
    public String logout(){
        Subject subject = SecurityUtils.getSubject();
        subject.logout();
        return "redirect:/login";
    }

}
