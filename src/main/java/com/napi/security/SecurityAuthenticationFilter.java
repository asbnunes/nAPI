/**
 * Andre Santoro, Gustavo Pedro Lima, Maisa Moreira
 *
 * 01/10/2022
 *
 * Esse programa foi feito para fins educativos, para a materia
 * de Programacaoo Orientada a Objetos, oferecida no Centro
 * Universitário IESB no periodo 2022.2, ministrada pelo professor
 * Kenniston Arraes.
 */
package com.napi.security;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.napi.email.EmailController;
import com.napi.registration.RegistrationRequest;
import com.napi.user.UserData;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import javax.servlet.FilterChain;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;

public class SecurityAuthenticationFilter extends UsernamePasswordAuthenticationFilter {

    private static final long EXPIRATION_TIME = 900_000;

    public static final String SECRET = "d4d2ff3c-956a-4cb5-b8aa-28fd22f0fd5e";

    public AuthenticationManager authenticationManager;
    public SecurityAuthenticationFilter(AuthenticationManager authenticationManager) {
    }


    @Override
    public Authentication attemptAuthentication(HttpServletRequest request,
                                                HttpServletResponse response)
            throws AuthenticationException {

        try {
            UserData userData = new ObjectMapper()
                    .readValue(request.getInputStream(), UserData.class);
            return authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(
                            userData.getEmail(),
                            userData.getSenha(),
                            new ArrayList<>())
            );
        } catch (IOException e) {
            throw new RuntimeException("Falha ao autenticar",e);
        }
    }

    @Override
    protected void successfulAuthentication(HttpServletRequest req,
                                            HttpServletResponse res,
                                            FilterChain chain,
                                            Authentication authResult) throws IOException {

        UserData usuarioData = (UserData) authResult.getPrincipal();

        String token = JWT.create()
                .withSubject(usuarioData.getUsername())
                .withExpiresAt(new Date(System.currentTimeMillis() + EXPIRATION_TIME))
                .sign(Algorithm.HMAC512(SECRET.getBytes()));

        res.getWriter().write("Token:" + token);
        res.getWriter().flush();
    }
}