//package com.pollen.pollenweb.controller;
//
//
//import com.pollen.pollenweb.entity.Users;
//import com.pollen.pollenweb.exception.PwException;
//import com.pollen.pollenweb.form.UserLoginForm;
//import com.pollen.pollenweb.form.UserRegisterForm;
//import com.pollen.pollenweb.result.ResponseEnum;
//import com.pollen.pollenweb.service.UsersService;
//import lombok.extern.slf4j.Slf4j;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.validation.BindingResult;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.RequestMapping;
//
//import org.springframework.stereotype.Controller;
//import org.springframework.web.servlet.ModelAndView;
//
//import javax.servlet.http.HttpSession;
//import javax.validation.Valid;
//
///**
// * <p>
// *  前端控制器
// * </p>
// *
// * @author yyq
// * @since 2022-01-16
// */
//@Controller
//@RequestMapping("/users")
//@Slf4j
//public class UsersController {
//    @Autowired
//    private UsersService usersService;
//
//    @PostMapping("/register")
//    public String register(@Valid UserRegisterForm userRegisterForm, BindingResult bindingResult){  //绑定到一起进行相关错误收集校验
//
//        /**
//         * 用户注册
//         */
//        //非空校验
//        if(bindingResult.hasErrors()){
//            log.info("【用户注册】用户信息不能为空");
//            throw new PwException(ResponseEnum.USER_INFO_NULL);
//        }
//        Users register = this.usersService.register(userRegisterForm);
//        if(register == null){
//            log.info("【用户注册】添加用户失败");
//            throw new PwException(ResponseEnum.USER_REGISTER_ERROR);
//        }
//        return "redirect:/login";
//    }
//
//    /**
//     * 登录
//     * @return
//     */
//    @PostMapping("/login")
//    public ModelAndView login(@Valid UserLoginForm userLoginForm, BindingResult bindingResult, HttpSession session){
//        //非空校验
//        if(bindingResult.hasErrors()){
//            log.info("【用户登录】用户信息不能为空");
//            throw new PwException(ResponseEnum.USER_INFO_NULL);
//        }
//        Users login = this.usersService.login(userLoginForm);
//        if(login==null){
//            log.info("【用户登录】登录失败");
//        }
//        session.setAttribute("user",login);
//        ModelAndView modelAndView = new ModelAndView();
//        modelAndView.setViewName("index");
//        return modelAndView;
//    }
//
//    /**
//     * 注销
//     * @param session
//     * @return
//     */
//    @GetMapping
//    @RequestMapping("/logout")
//    public String logout(HttpSession session){
//        System.out.println("logout");
//        //session失效
//
//        session.removeAttribute("user");
//        if(session==null){
//            log.info("【用户注销】注销成功");
//        }
//        return "redirect:/login";
//    }
//}
//
