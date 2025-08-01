package com.voskan.myhub.security;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.interfaces.DecodedJWT;
import com.auth0.jwt.interfaces.JWTVerifier;

public class JwtUtil {

    private final JWTVerifier verifier;

    public JwtUtil(String secret) {
        Algorithm algorithm = Algorithm.HMAC256(secret);
        this.verifier = JWT.require(algorithm).build();
    }

    public DecodedJWT validateToken(String token) {
        return verifier.verify(token);
    }

    public String getUserId(DecodedJWT jwt) {
        return jwt.getSubject(); // assumes UUID is stored in "sub" claim
    }
}