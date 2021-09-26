package com.shoppcrypto.shoppcrypto.config.jwt;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
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

    public static final String TOKEN_HEADER_NAME = "Authorization";
    public static final String TOKEN_TYPE = "Bearer ";

    public JwtValidatorFilter(AuthenticationManager authenticationManager) {
        super(authenticationManager);
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
        String user = JWT.require(Algorithm.HMAC512(JwtAuthenticationFilter.TOKEN_GUID))
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
