package com.asian.backend.domains.dto.repository;



import com.asian.backend.domains.dto.ForgotPassWordRedisDto;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ForgotPasswordRedisRepository extends CrudRepository<ForgotPassWordRedisDto, Long> {
    Optional<ForgotPassWordRedisDto> findByEmail(String email);
}
