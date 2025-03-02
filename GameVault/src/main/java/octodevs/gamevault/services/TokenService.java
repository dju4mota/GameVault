package octodevs.gamevault.services;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;

import octodevs.gamevault.models.User;

import org.springframework.stereotype.Service;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneOffset;

@Service
public class TokenService {

    public String generateToken(User user) {
        try {
            Algorithm algorithm = Algorithm.HMAC256("secret");
            return  JWT.create()
                    .withIssuer("auth0")
                    .withSubject(user.getLogin())
                    .withExpiresAt(generateDate())
                    .sign(algorithm);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    private Instant generateDate() {
        return LocalDateTime.now().plusHours(2).toInstant(ZoneOffset.of("-03:00"));
    }
}
