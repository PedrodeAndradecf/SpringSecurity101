package EstudosJava.SpringSec.config;

import EstudosJava.SpringSec.entity.User;
import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import org.springframework.stereotype.Component;

import java.time.Instant;

@Component
public class TokenConfig {
    private String secret = "secretKey"; // o ideal é colocar na variavel de ambiente ou no properties

    public String getSecret(User user) {

        Algorithm algorithm = Algorithm.HMAC256(secret);


        return JWT.create()
                .withClaim("userId", user.getId())
                .withSubject(user.getEmail())
                .withExpiresAt(Instant.now().plusSeconds(3600))
                .withIssuedAt(Instant.now())
                .sign(algorithm);

    }
}
