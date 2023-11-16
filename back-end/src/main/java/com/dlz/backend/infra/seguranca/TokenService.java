package com.dlz.backend.infra.seguranca;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTCreationException;
import com.auth0.jwt.exceptions.JWTVerificationException;
import com.dlz.backend.model.Cliente.Cliente;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneOffset;

@Service
public class TokenService {

    //TODO: mudar para uma chave mais segura em caso de aplicação real
    private static final String secret = "senhaSecreta";

    public String gerarToken(Cliente cliente) {
        try{
            Algorithm algorithm = Algorithm.HMAC256(secret);
            String token = JWT.create()
                    .withIssuer("dlz-supermercados")
                    .withSubject(cliente.getEmail())
                    .withExpiresAt(gerarDataExpiracao())
                    .sign(algorithm);

            return token;
        }catch (JWTCreationException exception){
            throw new RuntimeException("Erro ao gerar token", exception);
        }
    }

    public static String validarToken(String token){
        try{
            Algorithm algorithm = Algorithm.HMAC256(secret);
            return JWT.require(algorithm)
                    .withIssuer("dlz-supermercados")
                    .build()
                    .verify(token)
                    .getSubject();

        }catch (JWTVerificationException exception){
            return "";
        }
    }

    private Instant gerarDataExpiracao() {
        return LocalDateTime.now().plusHours(2).toInstant(ZoneOffset.of("-03:00"));
    }
}
