package com.mycompany.property_management.service;

import com.mycompany.property_management.dto.UserDto;
import com.mycompany.property_management.exception.BusinessException;
import org.springframework.stereotype.Service;

@Service
public interface UserService {

    UserDto register(UserDto userDto) throws BusinessException;
    UserDto login(String email,String password) throws BusinessException;
}
