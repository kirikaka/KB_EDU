package org.example.security.util;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jws;
import io.jsonwebtoken.Jwt;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Component;

import java.nio.charset.StandardCharsets;
import java.security.Key;
import java.util.Date;

@Component
public class JwtProcessor {
    static private final long TOKEN_VALIDITY_MILSECONDS = 1000L*60*5;

    private String secretKey="ldsfanofoi143n435436lnvfnslvnfh_454lnlg!@eelflnfl";
    private Key key= Keys.hmacShaKeyFor(secretKey.getBytes(StandardCharsets.UTF_8));

    // Generating JWT
    public String generateToken(String subject){
        return Jwts.builder()
                .setSubject(subject)
                .setIssuedAt(new Date())
                .setExpiration(new Date(new Date().getTime() + TOKEN_VALIDITY_MILSECONDS))
                .signWith(key)
                .compact();

    }

    public String getUsername(String token){
        return Jwts.parserBuilder()
                .setSigningKey(key)
                .build()
                .parseClaimsJws(token).getBody().getSubject();
    }


    public  boolean validateToken(String token){
        Jws<Claims> claims = Jwts.parserBuilder()
                .setSigningKey(key)
                .build()
                .parseClaimsJws(token);
        return true;

    }
}
