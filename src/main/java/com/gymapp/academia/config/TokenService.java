package com.gymapp.academia.config;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTVerificationException;
import com.auth0.jwt.interfaces.DecodedJWT;
import com.gymapp.academia.auth.domain.User;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.time.Instant;
import java.util.Optional;

@Component
public class TokenService {
    @Value("${jwt.secret}")
    private String secret;
    public String generateToken(User user){
        Algorithm algorithm = Algorithm.HMAC256(secret);
        return JWT.create()
                .withSubject(user.getUsername())
                .withClaim("UserId", user.getId())
                .withExpiresAt(Instant.now().plusSeconds(86400))
                .withIssuedAt(Instant.now())
                .withIssuer("API-ACADEMIA")
                .sign(algorithm);

    }

    public Optional<String> verifyToken(String token) {
        try {
            Algorithm algorithm = Algorithm.HMAC256(secret);

            DecodedJWT jwt = JWT.require(algorithm)
                    .build()
                    .verify(token);

            return Optional.of(jwt.getSubject());

        } catch (JWTVerificationException e) {
            return Optional.empty();
        }
    }



}
