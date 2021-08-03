package com.andremapa.RegisterSystem.DTO.Response;

import com.andremapa.RegisterSystem.Models.User;

import java.util.Date;

public class UserDTOResponse {

    private final String name;
    private final String cpf;
    private final String email;
    private final Date birthDate;
    private final String phoneNumber;
    private final String street;
    private final String houseNumber;
    private final String neighborhood;
    private final String city;
    private final String state;
    private final String cep;

    public UserDTOResponse(User user) {
        this.name = user.getName();
        this.cpf = user.getCpf();
        this.email = user.getEmail();
        this.birthDate = user.getBirthDate();
        this.phoneNumber = user.getPhoneNumber();
        this.street = user.getStreet();
        this.houseNumber = user.getHouseNumber();
        this.neighborhood = user.getNeighborhood();
        this.city = user.getCity();
        this.state = user.getState();
        this.cep = user.getCep();
    }

    public String getName() {
        return name;
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
