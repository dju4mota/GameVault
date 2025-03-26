package octodevs.gamevault.services;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneOffset;

import javax.management.RuntimeErrorException;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTCreationException;
import com.auth0.jwt.exceptions.JWTVerificationException;

import octodevs.gamevault.models.UserAccount;

@Service
public class TokenService {

    @Value("${api.security.token.secret}")
    private String secrete;

    public String generateToken(UserAccount userAccount){
        try {
            
            Algorithm alg = Algorithm.HMAC256(secrete);
            String token = JWT.create()
                .withIssuer("auth-api")
                .withSubject(userAccount.getUserName())
                .withExpiresAt(generateExpirionDate())
                .sign(alg);
            
            return token;

        } catch (JWTCreationException e) {
            throw new RuntimeException("Error while generating token", e);            
        }
    }

    public String validateToken(String token ){
        try {
            
            Algorithm alg = Algorithm.HMAC256(secrete);
            return JWT.require(alg)
                .withIssuer("auth-api")
                .build()
                .verify(token)
                .getSubject();                

        } catch (JWTVerificationException e) {
            return "";
        }
    }

    private Instant generateExpirionDate(){
        return LocalDateTime.now().plusHours(3).toInstant(ZoneOffset.of("-03:00"));
    }
}
