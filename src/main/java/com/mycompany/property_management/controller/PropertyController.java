package com.mycompany.property_management.controller;

import com.mycompany.property_management.dto.PropertyDto;
//import com.mycompany.property_management.retrieval.PropertyCalls;
import com.mycompany.property_management.retrieval.PropertyCalls;
import com.mycompany.property_management.service.PropertyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URISyntaxException;
import java.util.List;

@RestController
@RequestMapping("/api/v1")
public class PropertyController {

    @Autowired
    private PropertyService propertyService;

    @Autowired
    private PropertyCalls propertyCalls;

    @GetMapping("/hello")
    public String sayHello(){
        return "Hello";
    }

    @GetMapping("/callhello")
    public  ResponseEntity<String>  callHello() throws URISyntaxException {
        ResponseEntity<String> responseEntity = propertyCalls.callHello();
        return responseEntity;
    }

    @PostMapping("/properties")
    public ResponseEntity<PropertyDto> saveProperty(@RequestBody PropertyDto propertyDto){
        PropertyDto propertyDtoReturned = propertyService.saveProperty(propertyDto);
        ResponseEntity<PropertyDto> responseEntity= new ResponseEntity<>(propertyDto, HttpStatus.CREATED);
        System.out.println(propertyDto);
        return responseEntity;
    }


    @GetMapping("/properties")
    public ResponseEntity<List<PropertyDto>> getAllProperties(){

        List<PropertyDto> propertyList= propertyService.getAllProperties();
        ResponseEntity<List<PropertyDto>> responseEntity = new ResponseEntity<>(propertyList,HttpStatus.OK);
        return responseEntity;

    }

    @PutMapping ("/properties/{id}")
    public ResponseEntity<PropertyDto> updateProperty(@RequestBody PropertyDto propertyDto,@PathVariable Long id){
        PropertyDto propertyDto1 = propertyService.updateProperty(propertyDto,id);
        ResponseEntity<PropertyDto> responseEntity = new ResponseEntity<>(propertyDto1,HttpStatus.CREATED);
        return responseEntity;
    }

    @PatchMapping("properties/update-description/{id}")
    public ResponseEntity updatePropertyDescription(@RequestBody PropertyDto propertyDto, @PathVariable Long id){
        ResponseEntity<PropertyDto> responseEntity = new ResponseEntity<>(propertyService.updatePropertyDescription(propertyDto,id),HttpStatus.CREATED);
        return responseEntity;

    }
    @PatchMapping("properties/update-price/{id}")
    public ResponseEntity<PropertyDto> updatePropertyPrice(@RequestBody PropertyDto propertyDto, @PathVariable Long id){
        PropertyDto propertyDto1 = propertyService.updatePropertyPrice(propertyDto,id);
        ResponseEntity<PropertyDto> responseEntity= new ResponseEntity<>(propertyDto1,HttpStatus.CREATED);
        return responseEntity;


    }

    @DeleteMapping("/properties/{id}")
    public ResponseEntity<String> deleteProperty(@PathVariable Long id){
        propertyService.deleteProperty(id);
        ResponseEntity<String> responseEntity = new ResponseEntity<>("deleted: "+id, HttpStatus.OK);
        return responseEntity;
    }


}
