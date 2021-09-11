package com.asian.backend.security.oauth2.service;



import com.asian.backend.dbprovider.UserRepository;
import com.asian.backend.domains.entity.UserEntity;
import com.asian.backend.security.oauth2.dto.UserPrincipalOauth2;
import com.asian.backend.utils.constants.AppConstant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;


@Service(value = "userCustomService")
public class CustomUserDetailsService implements UserDetailsService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        UserEntity userEntity = userRepository.findOneByEmailOrUserNameAndStatus(email, email, AppConstant.ACTIVE.ACTIVE_STATUS);
        if (userEntity == null) {
            throw new UsernameNotFoundException("User not found");
        }

        return UserPrincipalOauth2.createPrincipalOauth2(userEntity);
    }
}