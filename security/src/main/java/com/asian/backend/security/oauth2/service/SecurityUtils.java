package com.asian.backend.security.oauth2.service;


import com.asian.backend.security.oauth2.dto.UserPrincipalOauth2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.oauth2.common.OAuth2AccessToken;
import org.springframework.security.oauth2.provider.token.TokenStore;
import org.springframework.stereotype.Component;

import java.util.Map;

@Component
public class SecurityUtils {

    @Autowired
    private TokenStore tokenStore;

    public UserPrincipalOauth2 getPrincipal() {
        UserPrincipalOauth2 userPrincipalOauth2 = (UserPrincipalOauth2) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        return userPrincipalOauth2;
    }

    public Map<String, Object> getAdditional(String token) {
        final OAuth2AccessToken accessToken = tokenStore.readAccessToken(token.split(" ")[1]);
        return accessToken.getAdditionalInformation();
    }

}
