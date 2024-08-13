package com.mycompany.property_management.controller;


import com.mycompany.property_management.dto.UserDto;
import com.mycompany.property_management.service.UserService;
import org.apache.catalina.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/api/v1/user")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/register")
    public ResponseEntity<UserDto> register(@RequestBody UserDto userDto){
        UserDto userDto1 = userService.register(userDto);
        ResponseEntity<UserDto> responseEntity = new ResponseEntity<>(userDto1, HttpStatus.CREATED);
        return responseEntity;
    }

    @PostMapping("/login")
    public ResponseEntity<UserDto> login(@RequestBody String email,String password){
       UserDto userDto= userService.login(email, password);
       ResponseEntity<UserDto> responseEntity = new ResponseEntity<>(userDto,HttpStatus.OK);
       return responseEntity;
    }


}
