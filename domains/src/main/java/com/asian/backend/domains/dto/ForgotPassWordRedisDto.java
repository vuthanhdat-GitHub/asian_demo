package com.asian.backend.domains.dto;


import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.redis.core.RedisHash;
import org.springframework.data.redis.core.index.Indexed;

@RedisHash("forgot_password")
@NoArgsConstructor
@Getter
@Setter
public class ForgotPassWordRedisDto {
    @Id
    private Long id;
    @Indexed
    private String email;
    private Integer status;
}
