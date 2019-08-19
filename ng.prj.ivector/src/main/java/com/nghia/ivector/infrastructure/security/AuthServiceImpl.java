package com.nghia.ivector.infrastructure.security;

import com.nghia.ivector.domain.user.TokenInfo;
import com.nghia.ivector.domain.user.User;
import com.nghia.ivector.domain.user.repository.UserRepository;
import com.nghia.ivector.infrastructure.exception.ResourceNotFoundException;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.JwtBuilder;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.MalformedJwtException;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.SignatureException;
import io.jsonwebtoken.UnsupportedJwtException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.Date;

@Service
public class AuthServiceImpl implements UserDetailsService {
    private final Logger logger = LoggerFactory.getLogger(this.getClass());
    @Autowired
    private UserRepository userRepository;

    @Value("${app.jwtExpirationInMs}")
    private int jwtExpirationInMs;

    @Value("${app.jwtSecret}")
    private String jwtSecret;
    private JwtBuilder jwtBuilder;

    @PostConstruct
    public void init() {
        jwtBuilder = Jwts.builder().signWith(SignatureAlgorithm.HS512, jwtSecret);
    }

    @Override
    public UserDetails loadUserByUsername(String usernameOrEmail)
            throws UsernameNotFoundException {
        User user = new User();
        user.setEmail("nghia");
        return user;
//        return userRepository.findByEmail(usernameOrEmail)
//                .orElseThrow(() -> new UsernameNotFoundException("User not found with username or email : " + usernameOrEmail));
    }

    public User loadUserById(String id) {
        return userRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException());
    }

    public TokenInfo generateToken(User userPrincipal) {
        Date now = new Date();
        long expireTime = now.getTime() + jwtExpirationInMs;

        String accessToken = jwtBuilder
                .setSubject(userPrincipal.getId())
                .setIssuedAt(now)
                .setExpiration(new Date(expireTime))
                .compact();

        String refreshToken = jwtBuilder
                .setSubject(userPrincipal.getId())
                .setIssuedAt(now)
                .setExpiration(new Date(7 * expireTime))
                .compact();

        return TokenInfo.builder()
                .accessToken(accessToken)
                .expireAt(expireTime)
                .refreshToken(refreshToken)
                .tokenType("bearer")
                .build();

    }

    public String getUserIdFromJWT(String token) {
        Claims claims = Jwts.parser()
                .setSigningKey(jwtSecret)
                .parseClaimsJws(token)
                .getBody();

        return claims.getSubject();
    }

    public boolean validateToken(String authToken) {
        try {
            Jwts.parser().setSigningKey(jwtSecret).parseClaimsJws(authToken);
            return true;
        } catch (SignatureException ex) {
            logger.error("Invalid JWT signature");
        } catch (MalformedJwtException ex) {
            logger.error("Invalid JWT token");
        } catch (ExpiredJwtException ex) {
            logger.error("Expired JWT token");
        } catch (UnsupportedJwtException ex) {
            logger.error("Unsupported JWT token");
        } catch (IllegalArgumentException ex) {
            logger.error("JWT claims string is empty.");
        }
        return false;
    }

}