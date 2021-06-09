package com.sid.gestionparkitil.gestionparkitil.Securiter;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.interfaces.DecodedJWT;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.sid.gestionparkitil.gestionparkitil.Model.Permission;
import com.sid.gestionparkitil.gestionparkitil.Model.Utilisateur;
import com.sid.gestionparkitil.gestionparkitil.Service.AccountService;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class JwtTokenRefresher {

    private final AccountService accountService;

    public JwtTokenRefresher(AccountService accountService) {
        this.accountService = accountService;
    }

    public Map<String, String> refreshToken(HttpServletRequest request, HttpServletResponse response) throws Exception {
        String authorisationToken = request.getHeader(JWTUtil.AUTH_HEADER);
        if (authorisationToken != null && authorisationToken.startsWith(JWTUtil.PREFIX)) {
            try {
                String jwt = authorisationToken.substring(JWTUtil.PREFIX.length());
                Algorithm algo1 = Algorithm.HMAC256(JWTUtil.SECRET);
                JWTVerifier jwtVerifier = JWT.require(algo1).build();
                DecodedJWT decodedJWT = jwtVerifier.verify(jwt);
                String email = decodedJWT.getSubject();
                Utilisateur appUser = accountService.loadUserByUsername(email);
                String jwtAccessToken = JWT.create()
                        .withSubject(appUser.getEmail())
                        .withExpiresAt(new Date(System.currentTimeMillis() + JWTUtil.EXPIRE_ACCESS_TOKEN))
                        .withIssuer(request.getRequestURL().toString())
                        .withClaim("permissions", appUser.getPermissions().stream().map(p -> p.getCode()).collect(Collectors.toList()))
                        .sign(algo1);
                String jwtRefreshToken = JWT.create()
                        .withSubject(appUser.getEmail())
                        .withExpiresAt(new Date(System.currentTimeMillis() + JWTUtil.EXPIRE_REFRESH_TOKEN))
                        .withIssuer(request.getRequestURL().toString())
                        .sign(algo1);
                Map<String, String> idToken = new HashMap<>();
                idToken.put("accesstoken", jwtAccessToken);
                idToken.put("refreshtoken", jwtRefreshToken);
                response.setContentType("application/json");
                System.out.println("Refresh executed");
                //new ObjectMapper().writeValue(response.getOutputStream(), idToken);
                return idToken;
            } catch (Exception e) {
                throw e;
            }
        } else {
            throw new RuntimeException("Refresh Token Required!!!");
        }
    }
}
