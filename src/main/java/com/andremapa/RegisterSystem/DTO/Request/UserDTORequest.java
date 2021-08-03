package com.andremapa.RegisterSystem.DTO.Request;

import com.andremapa.RegisterSystem.Models.User;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.br.CPF;

import javax.validation.constraints.*;
import java.util.Date;

public class UserDTORequest {

    @NotEmpty(message = "Name cannot be null")
    private String name;
    @NotEmpty(message = "Password cannot be null")
    @Length(min = 4, max = 12, message = "Password must be between 4 and 12 characters")
    private String password;
    @CPF(message = "Cpf should be valid")
    @NotEmpty(message = "Cpf cannot be null")
    private String cpf;
    @Email(message = "Email should be valid")
    @NotEmpty(message = "Email cannot be null")
    private String email;
    @NotNull(message = "BirthDate cannot be null")
    private Date birthDate;
    @NotEmpty(message = "PhoneNumber cannot be null")
    @Pattern(regexp = "([(0-9)]{2}[ ]?[9][ ]?[0-9]{4}-[0-9]{4})")
    private String phoneNumber;
    @NotEmpty(message = "Street cannot be null")
    private String street;
    @NotEmpty(message = "HouseNumber cannot be null")
    private String houseNumber;
    @NotEmpty(message = "Neighborhood cannot be null")
    private String neighborhood;
    @NotEmpty(message = "City cannot be null")
    private String city;
    @NotEmpty(message = "State cannot be null")
    private String state;
    @NotEmpty(message = "Cep cannot be null")
    @Pattern(regexp = "([0-9]{2}[.][0-9]{3}[-][0-9]{3})")
    private String cep;

    public UserDTORequest(String name, String password, String cpf, String email, Date birthDate, String phoneNumber, String street,
                          String houseNumber, String neighborhood, String city, String state, String cep) {
        this.name = name;
        this.password = password;
        this.cpf = cpf;
        this.email = email;
        this.birthDate = birthDate;
        this.phoneNumber = phoneNumber;
        this.street = street;
        this.houseNumber = houseNumber;
        this.neighborhood = neighborhood;
        this.city = city;
        this.state = state;
        this.cep = cep;
    }

    public User toModel(){
        return new User(this.name, this.password, this.cpf, this.email, this.birthDate, this.phoneNumber, this.street, this.houseNumber,
                this.neighborhood, this.city, this.state, this.cep);
    }

    public String getName() {
        return name;
    }

    public String getPassword() {
        return password;
    }

    public String getCpf() {
        return cpf;
    }

    public String getEmail() {
        return email;
    }

    public Date getBirthDate() {
        return birthDate;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public String getStreet() {
        return street;
    }

    public String getHouseNumber() {
        return houseNumber;
    }

    public String getNeighborhood() {
        return neighborhood;
    }

    public String getCity() {
        return city;
    }

    public String getState() {
        return state;
    }

    public String getCep() {
        return cep;
    }
}
