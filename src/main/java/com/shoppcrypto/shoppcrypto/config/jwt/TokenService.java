package com.shoppcrypto.shoppcrypto.config.jwt;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.shoppcrypto.shoppcrypto.config.ConfigProperties;
import com.shoppcrypto.shoppcrypto.config.security.UserDetailsImpl;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;
import java.util.Date;

@Service
public class TokenService {

    //shoppcrypto.jwt.expiration
    private Integer TOKEN_DURATION;

    //shoppcrypto.jwt.secret
    private String TOKEN_SECRET;

    private ConfigProperties configProperties;

    public TokenService(ConfigProperties configProperties) {
        this.configProperties = configProperties;
        this.TOKEN_SECRET = this.configProperties.getConfigValue("shoppcrypto.jwt.secret");
        this.TOKEN_DURATION = Integer.parseInt(this.configProperties.getConfigValue("shoppcrypto.jwt.expiration"));
    }

    public String tokenGen( Authentication authentication){
        UserDetailsImpl userDetails = (UserDetailsImpl) authentication.getPrincipal();

        return JWT.create()
                .withSubject(userDetails.getUsername())
                .withExpiresAt(new Date(System.currentTimeMillis()+ TOKEN_DURATION))
                .sign(Algorithm.HMAC512(TOKEN_SECRET));
    }

}