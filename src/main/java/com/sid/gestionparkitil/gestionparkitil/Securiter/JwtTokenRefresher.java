package com.sid.gestionparkitil.gestionparkitil.Securiter;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.interfaces.DecodedJWT;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.sid.gestionparkitil.gestionparkitil.Model.Utilisateur;
import com.sid.gestionparkitil.gestionparkitil.Service.AccountService;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@Service
public class JwtTokenRefresher {

    private AccountService accountService;

    public JwtTokenRefresher(AccountService accountService) {
        this.accountService = accountService;
    }

    public void refreshToken(HttpServletRequest request, HttpServletResponse response) throws Exception{
        String authorisationToken =request.getHeader(JWTUtil.AUTH_HEADER);
        if(authorisationToken!=null && authorisationToken.startsWith(JWTUtil.PREFIX)){
            try {
                String jwt=authorisationToken.substring(JWTUtil.PREFIX.length());
                Algorithm algorithm =Algorithm.HMAC256(JWTUtil.SECRET);
                JWTVerifier jwtVerifier= JWT.require(algorithm).build();
                DecodedJWT decodedJWT = jwtVerifier.verify(jwt);
                String username = decodedJWT.getSubject();
                System.out.println(username);
                Utilisateur appUser = accountService.loadUserByUsername(username);
                String jwtAccessToken = JWT.create()
                        .withSubject(appUser.getEmail())
                        .withExpiresAt(new Date(System.currentTimeMillis()+JWTUtil.EXPIRE_ACCESS_TOKEN))
                        .withIssuer(request.getRequestURL().toString())
                        .sign(algorithm);
                Map<String,String> idToken =new HashMap<>();
                idToken.put("access-token",jwtAccessToken);
                idToken.put("refresh-token",jwt);
                response.setContentType("application/json");
                new ObjectMapper().writeValue(response.getOutputStream(),idToken);
            }
            catch (Exception e){
                throw e;
            }
        }
        else{
            throw new RuntimeException("Refresh Token Required!!!");
        }
    }
}