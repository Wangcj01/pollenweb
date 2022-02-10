//package com.pollen.pollenweb.entity;
//
//import com.baomidou.mybatisplus.annotation.*;
//
//import java.io.File;
//import java.time.LocalDate;
//import java.time.LocalDateTime;
//import java.time.LocalTime;
//import java.io.Serializable;
//import lombok.Data;
//import lombok.EqualsAndHashCode;
//
///**
// * <p>
// *
// * </p>
// *
// * @author yyq
// * @since 2022-01-16
// */
//@Data
//  @EqualsAndHashCode(callSuper = false)
//    @TableName("Users")
//public class Users implements Serializable {
//
//    private static final long serialVersionUID=1L;
//
//      @TableId(value = "id", type = IdType.AUTO)
//      private Integer id;
//
//    private String loginName;
//
//    private String userName;
//
//    private String password;
//
//    private String phoneNumber;
//
//    private String email;
//
//    private String note;
//
//    private String fileName;
//
//    @TableField(fill = FieldFill.INSERT)
//    private LocalDateTime createdTime;
//
//    @TableField(fill = FieldFill.INSERT_UPDATE)
//    private LocalDateTime lastLogin;
//
//
//}
