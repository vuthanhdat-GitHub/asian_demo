package com.asian.backend.security.oauth2.dto;

import com.asian.backend.domains.entity.UserEntity;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

@Data
public class UserPrincipalOauth2 implements UserDetails {

    private String username;
    @JsonIgnore
    private String password;
    private Long userId;
    private String email;
    //private int hourToken;


    private Collection<? extends GrantedAuthority> authorities;

    public UserPrincipalOauth2(String username, String password, String email, Long userId, Collection<? extends GrantedAuthority> authorities /*, int hourToken*/) {
        this.username = username;
        this.password = password;
        this.userId = userId;
        this.email = email;
        this.authorities = authorities;
        //this.hourToken = hourToken;
    }

    // get roles and set authorities
    public static UserPrincipalOauth2 createPrincipalOauth2(UserEntity userEntity) {
        List<GrantedAuthority> authorities = userEntity.getRoles().stream().map(roleEntity ->
                new SimpleGrantedAuthority("ROLE_" + roleEntity.getCode())
        ).collect(Collectors.toList());
        return new UserPrincipalOauth2(
                userEntity.getUserName(),
                userEntity.getPassword(),
                userEntity.getEmail(),
                userEntity.getId(),
                authorities
                //userEntity.getHourToken()
        );
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}
