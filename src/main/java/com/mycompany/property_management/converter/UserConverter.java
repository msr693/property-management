package com.mycompany.property_management.converter;

import com.mycompany.property_management.dto.UserDto;
import com.mycompany.property_management.entity.UserEntity;
import org.springframework.context.annotation.Configuration;

@Configuration
public class UserConverter {

    public UserEntity convertDtotoEntity(UserDto userDto){
        UserEntity userEntity= new UserEntity();
        userEntity.setPhone(userDto.getPhone());
        userEntity.setPassword(userDto.getPassword());
        userEntity.setOwnerEmail(userDto.getOwnerEmail());
        userEntity.setOwnerName(userDto.getOwnerName());
        return userEntity;

    }

    public UserDto convertEntitytoDto(UserEntity userEntity){
        UserDto userDto= new UserDto();
        userDto.setPhone(userEntity.getPhone());
        userDto.setPassword(userEntity.getPassword());
        userDto.setOwnerEmail(userEntity.getOwnerEmail());
        userDto.setOwnerName(userEntity.getOwnerName());
        return userDto;

    }
}
