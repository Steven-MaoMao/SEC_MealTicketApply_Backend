package com.SEC.SEC_MealTicketApply_Backend.Controller;

import com.SEC.SEC_MealTicketApply_Backend.Domain.LoginData;
import com.SEC.SEC_MealTicketApply_Backend.Domain.User;
import com.SEC.SEC_MealTicketApply_Backend.Service.IUserService;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import static com.SEC.SEC_MealTicketApply_Backend.JWT.Jwt.createToken;

@RestController
@RequestMapping("/login")
@CrossOrigin
public class LoginController {
    @Autowired
    private IUserService userService;

//  登录逻辑，成功返回token或"user"或"scanner"；失败返回字符串"PHONE_ERROR"或"PASSWORD_ERROR"
    @PostMapping
    public String login(@RequestBody LoginData loginData) {
        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("phone", loginData.getPhone());
        User result = userService.getOne(queryWrapper);
        if (result == null) return "PHONE_ERROR";
        if (!result.getPassword().equals(loginData.getPassword())) {
            return "PASSWORD_ERROR";
        }
        if(result.getRole().equals("manager")){
            return createToken(loginData.getPhone());
        } else {
            return result.getRole();
        }
    }
}