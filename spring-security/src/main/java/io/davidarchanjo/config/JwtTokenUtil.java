package io.davidarchanjo.config;

import io.davidarchanjo.model.dto.UserDTO;
import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.MalformedJwtException;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.SignatureException;
import io.jsonwebtoken.UnsupportedJwtException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.Date;

@Slf4j
@Component
@RequiredArgsConstructor
public class JwtTokenUtil {

    private static final String JWT_SECRET = "abcdefghijklmnopqrstuvwxyz1234567890";
    private static final String JWT_ISSUER = "io.davidarchanjo";

    public String generateAccessToken(UserDTO user) {
        return Jwts.builder()
            .setSubject(String.format("%s,%s", user.getId(), user.getUsername()))
            .setIssuer(JWT_ISSUER)
            .setIssuedAt(new Date())
            .setExpiration(new Date(System.currentTimeMillis() + 2 * 24 * 60 * 60 * 1000)) // 1 week
            .signWith(SignatureAlgorithm.HS512, JWT_SECRET)
            .compact();
    }

    public String getUserId(String token) {
        return Jwts.parser()
            .setSigningKey(JWT_SECRET)
            .parseClaimsJws(token)
            .getBody()
            .getSubject().split(",")[0];
    }

    public String getUsername(String token) {
        return Jwts.parser()
            .setSigningKey(JWT_SECRET)
            .parseClaimsJws(token)
            .getBody()
            .getSubject().split(",")[1];
    }

    public Date getExpirationDate(String token) {
        return Jwts.parser()
            .setSigningKey(JWT_SECRET)
            .parseClaimsJws(token)
            .getBody()
            .getExpiration();
    }

    public boolean isValidate(String token) {
        try {
            Jwts.parser().setSigningKey(JWT_SECRET).parseClaimsJws(token);
            return true;
        } catch (SignatureException ex) {
            log.error("Invalid JWT signature - {}", ex.getMessage());
        } catch (MalformedJwtException ex) {
            log.error("Invalid JWT token - {}", ex.getMessage());
        } catch (ExpiredJwtException ex) {
            log.error("Expired JWT token - {}", ex.getMessage());
        } catch (UnsupportedJwtException ex) {
            log.error("Unsupported JWT token - {}", ex.getMessage());
        } catch (IllegalArgumentException ex) {
            log.error("JWT claims string is empty - {}", ex.getMessage());
        }
        return false;
    }

}
