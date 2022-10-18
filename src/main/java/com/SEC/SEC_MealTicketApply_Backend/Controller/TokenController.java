package com.SEC.SEC_MealTicketApply_Backend.Controller;

import org.springframework.web.bind.annotation.*;

import static com.SEC.SEC_MealTicketApply_Backend.JWT.Jwt.parseToken;


@RestController
@RequestMapping("/token")
@CrossOrigin
public class TokenController {
//  返回解密后的token值，即该用户的账号（手机号）
    @PostMapping
    public String token(@RequestBody String token) {
        return parseToken(token);
    }
}
