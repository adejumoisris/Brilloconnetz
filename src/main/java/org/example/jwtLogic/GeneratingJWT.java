package org.example.jwtLogic;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTDecodeException;
import com.auth0.jwt.exceptions.JWTVerificationException;

import static org.example.jwtSecretekeyConstant.SecreteKey.SECRETE_KEY;

public class GeneratingJWT {
    public static String generateJWT(String username, String email){
        Algorithm algorithm = Algorithm.HMAC256(SECRETE_KEY);
        return JWT.create()
                .withClaim("username", username)
                .withClaim("email", email)
                .sign(algorithm);

    }

    public static boolean verifyJWT(String token ){
        try {
            Algorithm algorithm = Algorithm.HMAC256(SECRETE_KEY);
            JWT.require(algorithm).build().verify(token);
            return true;

        }catch (JWTVerificationException e){
            return false;
        }
    }
}
