package com.mycompany.property_management.converter;


import com.mycompany.property_management.dto.PropertyDto;
import com.mycompany.property_management.entity.PropertyEntity;
import org.springframework.stereotype.Component;

@Component
public class PropertyConverter {
    public PropertyEntity convertDtoToEntity(PropertyDto propertyDto) {
        PropertyEntity propertyEntity = new PropertyEntity();
        propertyEntity.setTitle(propertyDto.getTitle());
        propertyEntity.setDescription(propertyDto.getDescription());
        propertyEntity.setAddress(propertyDto.getAddress());
        propertyEntity.setPrice(propertyDto.getPrice());

        return propertyEntity;
    }

    public PropertyDto convertEntitytoDto(PropertyEntity propertyEntity) {
        PropertyDto propertyDto = new PropertyDto();
        propertyDto.setTitle(propertyEntity.getTitle());
        propertyDto.setDescription(propertyEntity.getDescription());
        propertyDto.setAddress(propertyEntity.getAddress());
        propertyDto.setPrice(propertyEntity.getPrice());
        propertyDto.setId(propertyEntity.getId());
        return propertyDto;
    }

}
