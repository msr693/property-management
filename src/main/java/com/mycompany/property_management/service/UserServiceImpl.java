package com.mycompany.property_management.service;

import com.mycompany.property_management.converter.UserConverter;
import com.mycompany.property_management.dto.UserDto;
import com.mycompany.property_management.entity.UserEntity;
import com.mycompany.property_management.exception.BusinessException;
import com.mycompany.property_management.exception.ErrorModel;
import com.mycompany.property_management.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.expression.spel.support.ReflectivePropertyAccessor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService{

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private UserConverter userConverter;

    @Override
    public UserDto register(UserDto userDto) throws BusinessException {
        UserEntity userEntity = userConverter.convertDtotoEntity(userDto);
        Optional<UserEntity> byOwnerEmail = userRepository.findByOwnerEmail(userDto.getOwnerEmail());

        if(byOwnerEmail.isPresent()){
            List<ErrorModel> errorModelList = new ArrayList<>();
            ErrorModel errorModel = new ErrorModel();
            errorModel.setCode("EMAIL_ALREADY_EXISTS");
            errorModel.setMessage("Email with which you are trying to register exists");
            errorModelList.add(errorModel);
            throw new BusinessException(errorModelList);
        }

        userEntity =userRepository.save(userEntity);
        userDto = userConverter.convertEntitytoDto(userEntity);
        return userDto;
    }

    @Override
    public UserDto login(String email, String password) throws BusinessException {

        Optional<UserEntity> optUserEntity = userRepository.findByOwnerEmailAndPassword(email, password);

        UserDto userDto = null;
        if (optUserEntity.isPresent()) {
            userDto = userConverter.convertEntitytoDto(optUserEntity.get());
        }else{
            List<ErrorModel> errorModelList= new ArrayList<>();
            ErrorModel errorModel = new ErrorModel();
            errorModel.setCode("INVALID_LOGIN");
            errorModel.setMessage("Incorrect email or password");
            errorModelList.add(errorModel);

            throw new BusinessException(errorModelList);

        }

        return userDto;
    }
}
