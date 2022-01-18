package com.pollen.pollenweb.form;

import lombok.Data;
import org.hibernate.validator.constraints.NotEmpty;

//专门用于接收前端数据 注册信息后端再次校验
@Data
public class UserRegisterForm {
    @NotEmpty(message = "登录名不能为空")
    private String loginName;
    @NotEmpty(message = "真实姓名不能为空")
    private String userName;
    @NotEmpty(message = "密码不能为空")
    private String password;
    @NotEmpty(message = "手机号不能为空")
    private String phoneNumber;
    @NotEmpty(message = "邮箱不能为空")
    private String email;
}
