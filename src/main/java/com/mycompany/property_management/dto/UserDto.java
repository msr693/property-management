package com.mycompany.property_management.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.Column;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Component;

@Getter
@Setter
@Component
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class UserDto {

    private  long Id;
    private  String ownerName;
    @NotNull(message = "email cannot be null")
    @NotEmpty(message = "email cannot be null")
    @Size(min = 1,max = 100,message = "check size ")
    private String ownerEmail;
    private String phone;
    @NotNull(message = "password cannot be null")
    @NotEmpty(message = "password cannot be null")
    private String password;
}
