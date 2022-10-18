package com.SEC.SEC_MealTicketApply_Backend.Domain;

import lombok.Data;

// 数据库User对应的实体类
@Data
public class User {
//  工号
    private String wno;

//  姓名
    private String name;

//  手机号
    private String phone;

//  邮箱
    private String email;

//  公司
    private String company;

//  部门
    private String department;

//  身份（user、manager、scanner）
    private String role;

//  密码（md5加密）
    private String password;
}
