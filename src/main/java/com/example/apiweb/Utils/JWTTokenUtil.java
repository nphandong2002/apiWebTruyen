package com.example.apiweb.Utils;

import com.example.apiweb.Entity.UserEntity;


import io.jsonwebtoken.*;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
public class JWTTokenUtil {
    private final String JWT_SECRET = "1rfwfwf90322532321rfwfwf90322532321rfwfwf9032253232";
    private final long JWT_EXP = 6048000000000L;

    public String generateToken(UserEntity user){
        Date now =  new Date();
        Date expDate = new Date(now.getTime() + JWT_EXP);
        return Jwts.builder()
                .setSubject(user.getUsername())
                .setIssuedAt(now)
                .setExpiration(expDate)
                .signWith(SignatureAlgorithm.HS256,JWT_SECRET)
                .compact();
    }
    public String getDataToke(String token){
        Claims claims = Jwts.parser()
                .setSigningKey(JWT_SECRET)
                .parseClaimsJws(token)
                .getBody();
        return claims.getSubject();
    }

    public boolean validateToken(String token){
        try {
            Jwts.parser().setSigningKey(JWT_SECRET).parseClaimsJws(token);
            return true;
        }catch (MalformedJwtException ex){
            System.out.println("Token khong ton tai");
        }catch (ExpiredJwtException ex){
            System.out.println("Token da het han");
        }catch (UnsupportedJwtException ex){
            System.out.println("Khong ho tro Token nay");
        }catch (IllegalArgumentException ex){
            System.out.println("Token rong");
        }
        return false;
    }
}
