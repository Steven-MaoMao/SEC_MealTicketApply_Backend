package com.SEC.SEC_MealTicketApply_Backend.JWT;

import io.jsonwebtoken.*;
import lombok.val;

import java.util.Date;
import java.util.UUID;

public class Jwt {
    private static final String signature = "SEC_MealTicketApply_Backend";

//  加密token
    public static String createToken(String phone) {
        JwtBuilder jwtBuilder = Jwts.builder();
        return jwtBuilder
                .setHeaderParam("typ", "JWT")
                .setHeaderParam("alg", "HS256")
                .claim("phone", phone)
                .setExpiration(new Date(System.currentTimeMillis()+1000*60*60*24))
                .signWith(SignatureAlgorithm.HS256, signature)
                .compact();
    }

//  解密token
    public static String parseToken(String jwtToken) {
        JwtParser jwtParser = Jwts.parser();
        Jws<Claims> claimsJws = jwtParser.setSigningKey(signature).parseClaimsJws(jwtToken);
        Claims body = claimsJws.getBody();
        return body.get("phone").toString();
    }
}
