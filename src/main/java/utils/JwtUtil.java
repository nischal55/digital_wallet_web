package utils;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.interfaces.DecodedJWT;

import java.util.Date;

public class JwtUtil {

    private static final String SECRET_KEY = "Nischal@123";

    public static String generateToken(String username) {
        try {
            Algorithm algorithm = Algorithm.HMAC256(SECRET_KEY);
            return JWT.create()
                    .withSubject(username)
                    .withIssuedAt(new Date())
                    .withExpiresAt(new Date(System.currentTimeMillis() + 1000 * 60 * 60))
                    .sign(algorithm);
        } catch (Exception e) {
            throw new RuntimeException("Error while generating token: " + e.getMessage());
        }
    }

    public static boolean validateToken(String token, String username) {
        try {
            Algorithm algorithm = Algorithm.HMAC256(SECRET_KEY);
            JWTVerifier verifier = JWT.require(algorithm)
                    .withSubject(username)
                    .build();
            DecodedJWT jwt = verifier.verify(token);

            // Check if the token is expired
            return !jwt.getExpiresAt().before(new Date());
        } catch (Exception exception) {
            throw new RuntimeException("Invalid or expired JWT token: " + exception.getMessage());
        }
    }

}
