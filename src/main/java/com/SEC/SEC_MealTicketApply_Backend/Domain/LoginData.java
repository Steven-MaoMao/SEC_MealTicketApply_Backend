package com.SEC.SEC_MealTicketApply_Backend.Domain;

import lombok.Data;

// 登录逻辑中从前端接收数据的格式
@Data
public class LoginData {
//  手机号
    private String phone;

//  密码
    private String password;
}
