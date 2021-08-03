package com.andremapa.RegisterSystem.Service;

import com.andremapa.RegisterSystem.DTO.Request.UserDTORequest;
import com.andremapa.RegisterSystem.DTO.Response.UserDTOResponse;
import com.andremapa.RegisterSystem.Models.User;
import com.andremapa.RegisterSystem.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    @Autowired
    UserRepository userRepository;

    public UserDTOResponse postUser(UserDTORequest userDTORequest){
        if(userRepository.existsByCpf(userDTORequest.getCpf())){
            return null;
        }

        if (userRepository.existsByEmail(userDTORequest.getEmail())){
            return null;
        }

        User user = userRepository.save(userDTORequest.toModel());

        return new UserDTOResponse(user);
    }

    public User getUser(String cpf){
        if(!userRepository.existsByCpf(cpf)){
            return null;
        }
        return userRepository.findByCpf(cpf);
    }

    public List<User> getAllUsers(){
        return userRepository.findAll();
    }
}
