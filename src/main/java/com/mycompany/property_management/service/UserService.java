package com.mycompany.property_management.service;

import com.mycompany.property_management.dto.UserDto;
import org.springframework.stereotype.Service;

@Service
public interface UserService {

    UserDto register(UserDto userDto);
    UserDto login(String email,String password);
}
