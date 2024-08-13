package com.mycompany.property_management.service;

import com.mycompany.property_management.controller.PropertyController;
import com.mycompany.property_management.converter.PropertyConverter;
import com.mycompany.property_management.dto.PropertyDto;
import com.mycompany.property_management.entity.PropertyEntity;
import com.mycompany.property_management.repository.PropertyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class PropertyServiceImpl implements PropertyService{

    @Autowired
    private PropertyRepository propertyRepository;
    @Autowired
    private PropertyConverter propertyConverter;

    @Override
    public PropertyDto saveProperty(PropertyDto propertyDto) {
        PropertyEntity propertyEntity = propertyRepository.save(propertyConverter.convertDtoToEntity(propertyDto));
        propertyDto=propertyConverter.convertEntitytoDto(propertyEntity);
        return propertyDto;
    }

    @Override
    public List<PropertyDto> getAllProperties() {
        List<PropertyEntity> propertyEntities = (List<PropertyEntity>) propertyRepository.findAll();
        List<PropertyDto> propertyDtoList = new ArrayList<>();
        for (PropertyEntity propertyEntity:propertyEntities){
           PropertyDto propertyDto = propertyConverter.convertEntitytoDto(propertyEntity);
           propertyDtoList.add(propertyDto);
        }

        return propertyDtoList;
    }

    @Override
    public PropertyDto updateProperty(PropertyDto propertyDto,Long propertyId) {
        Optional<PropertyEntity> optEn = propertyRepository.findById(propertyId);
        PropertyDto dto = null;
        if(optEn.isPresent()){
            PropertyEntity propertyEntity = optEn.get();

            propertyEntity.setPrice(propertyDto.getPrice());
            propertyEntity.setTitle(propertyDto.getTitle());
            propertyEntity.setAddress(propertyDto.getAddress());
            propertyEntity.setDescription(propertyDto.getDescription());


            propertyRepository.save(propertyEntity);
            dto = propertyConverter.convertEntitytoDto(propertyEntity);
        }

        return dto;
    }

    @Override
    public PropertyDto updatePropertyDescription(PropertyDto propertyDto, Long id) {
        Optional<PropertyEntity> optionalPe = propertyRepository.findById(id);

        PropertyDto propertyDto1 = null;
        if (optionalPe.isPresent()) {
            PropertyEntity pe = optionalPe.get();
            pe.setDescription(propertyDto.getDescription());
            propertyRepository.save(pe);
            propertyDto1 = propertyConverter.convertEntitytoDto(pe);
        }

        return propertyDto1;
    }

    @Override
    public PropertyDto updatePropertyPrice(PropertyDto propertyDto, Long id) {
        Optional<PropertyEntity> optionalPe = propertyRepository.findById(id);

        PropertyDto propertyDto1 = null;
        if (optionalPe.isPresent()) {
            PropertyEntity pe = optionalPe.get();
            pe.setPrice(propertyDto.getPrice());
            propertyRepository.save(pe);
            propertyDto1 = propertyConverter.convertEntitytoDto(pe);
            //test
        }

        return propertyDto1;
    }

    @Override
    public void deleteProperty(Long id) {
        propertyRepository.deleteById(id);
    }

}
