package com.mycompany.property_management.dto;

import jakarta.persistence.Column;
import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Component;

@Getter
@Setter
@Component
public class UserDto {

    private  String ownerName;
    private String ownerEmail;
    private String phone;
    private String password;
}
