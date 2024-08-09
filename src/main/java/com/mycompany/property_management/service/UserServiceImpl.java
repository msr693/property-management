package com.mycompany.property_management.service;

import com.mycompany.property_management.converter.UserConverter;
import com.mycompany.property_management.dto.UserDto;
import com.mycompany.property_management.entity.UserEntity;
import com.mycompany.property_management.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService{

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private UserConverter userConverter;

    @Override
    public UserDto register(UserDto userDto) {
        UserEntity userEntity = userConverter.convertDtotoEntity(userDto);
        userRepository.save(userEntity);
        return userDto;
    }

    @Override
    public UserDto login(String email, String password) {


        return null;
    }
}
