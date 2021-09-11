package com.asian.backend.domains.dto;


import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserDTO extends AbstractDTO<UserDTO> {
    private String email;
    private String userName;
    private String password;
    private String address;
    private Integer status;
}
