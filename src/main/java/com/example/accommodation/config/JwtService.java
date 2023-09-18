package com.example.accommodation.config;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class JwtService {

    @Value("${jwt.secret}")
    private String secret;


    public TokenInfo parseToken(String token) {
        Claims body = (Claims) Jwts.parserBuilder()
                .setSigningKey(secret.getBytes())
                .build()
                .parse(token)
                .getBody();

        TokenInfo info = TokenInfo.builder()
                .id(UUID.fromString(body.get("id", String.class)))
                .number(body.get("number", String.class))
                .name(body.get("name", String.class))
                .role(body.get("role", String.class))
                .build();
//        if(!info.getRole().equals("CUSTOMER")){
//            throw  new IllegalArgumentException("권한이 다릅니다");
//
//
//        } // 이건 여기선 필요없을듯..?
        return info;
    }


}
