package com.empyr.api.consumer.security;

import com.empyr.api.consumer.Config;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Date;

import static java.util.Collections.emptyList;

public class TokenAuthentication {
    static final long EXPIRATIONTIME = 864_000_000; // 10 days
    static final String SECRET = Config.getJwtSecret();
    static final String TOKEN_PREFIX = "Bearer ";
    static final String HEADER_STRING = "Authorization";

    public static void addAuthentication(HttpServletResponse res, String email) {
        String JWT = Jwts.builder()
                    .setSubject(email)
                    .setExpiration(new Date(System.currentTimeMillis() + EXPIRATIONTIME))
                    .signWith(SignatureAlgorithm.HS512, SECRET)
                    .compact();
        res.addHeader(HEADER_STRING, TOKEN_PREFIX + JWT);
        res.addHeader("Access-Control-Expose-Headers", HEADER_STRING);
    }

    public static Authentication getAuthentication(HttpServletRequest request) {
        String token = request.getHeader(HEADER_STRING);
        if (token != null) {
            // parse the token.
            try {
                String user = Jwts.parser()
                            .setSigningKey(SECRET)
                            .parseClaimsJws(token.replace(TOKEN_PREFIX, ""))
                            .getBody()
                            .getSubject();

                return user != null ?
                        new UsernamePasswordAuthenticationToken(user, null, emptyList()) :
                        null;
            } catch (Exception e){
                return null;
            }
        }
        return null;
    }
}