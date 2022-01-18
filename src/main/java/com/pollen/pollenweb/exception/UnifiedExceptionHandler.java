package com.pollen.pollenweb.exception;

import com.pollen.pollenweb.result.ResponseEnum;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.ModelAndView;

@RestControllerAdvice
public class UnifiedExceptionHandler {


    @ExceptionHandler(value = PwException.class)
    public ModelAndView handlerException(PwException e){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("register");
        ResponseEnum responseEnum = e.getResponseEnum();
        switch (responseEnum.getCode()){
            case 1003:
                modelAndView.setViewName("register");
                modelAndView.addObject("emailError",responseEnum.getMsg());
                break;
            case 1002:
                modelAndView.setViewName("register");
                modelAndView.addObject("userNameExists",responseEnum.getMsg());
                break;
            case 1004:
                modelAndView.setViewName("register");
                modelAndView.addObject("userRegisterError",responseEnum.getMsg());
                break;
            case 1005:
                modelAndView.setViewName("login");
                modelAndView.addObject("userNameError",responseEnum.getMsg());
                break;
            case 1006:
                modelAndView.setViewName("login");
                modelAndView.addObject("passwordError",responseEnum.getMsg());
                break;


        }

        return modelAndView;
    }
}
