package com.asian.backend.dbprovider;


import com.asian.backend.domains.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<UserEntity, Long> {
    UserEntity findOneByUserName(String userName);
    UserEntity findOneByEmailOrUserNameAndStatus(String email, String username, int status);
}
