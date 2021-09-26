package com.shoppcrypto.shoppcrypto.config.jwt;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.shoppcrypto.shoppcrypto.config.ConfigProperties;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.www.BasicAuthenticationFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;

public class JwtValidatorFilter extends BasicAuthenticationFilter {

    //shoppcrypto.jwt.expiration
    private Integer TOKEN_DURATION;

    //shoppcrypto.jwt.secret
    private String TOKEN_SECRET;

    private ConfigProperties configProperties;
    public static final String TOKEN_HEADER_NAME = "Authorization";
    public static final String TOKEN_TYPE = "Bearer ";

    public JwtValidatorFilter(AuthenticationManager authenticationManager, ConfigProperties configProperties) {
        super(authenticationManager);
        this.configProperties = configProperties;
        this.TOKEN_SECRET = configProperties.getConfigValue("shoppcrypto.jwt.secret");
        this.TOKEN_DURATION = Integer.parseInt(configProperties.getConfigValue("shoppcrypto.jwt.expiration"));
    }

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain chain) throws IOException, ServletException {
        String token = getToken(request);
        if (token != null) {
            UsernamePasswordAuthenticationToken usernamePasswordAuthenticationToken = getAuthentication(token);
            SecurityContextHolder.getContext().setAuthentication(usernamePasswordAuthenticationToken);
        }

        chain.doFilter(request, response);
    }

    private UsernamePasswordAuthenticationToken getAuthentication(String token){
        String user = JWT.require(Algorithm.HMAC512(TOKEN_SECRET))
                .build()
                .verify(token)
                .getSubject();

        return user==null ? null : new UsernamePasswordAuthenticationToken(user,null,new ArrayList<>());
    }

    private String getToken(HttpServletRequest request) {
        String token = request.getHeader(TOKEN_HEADER_NAME);
        if (token == null || token.isEmpty() || !token.startsWith(TOKEN_TYPE)) {
            return null;
        }

        return token.substring(7, token.length());
    }

}
