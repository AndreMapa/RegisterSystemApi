package com.andremapa.RegisterSystem.Controller;

import com.andremapa.RegisterSystem.DTO.Request.UserDTORequest;
import com.andremapa.RegisterSystem.DTO.Response.UserDTOResponse;
import com.andremapa.RegisterSystem.Models.User;
import com.andremapa.RegisterSystem.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("api/v1/main")
public class UserController {

    @Autowired
    UserService userService;

    @PostMapping
    public ResponseEntity<?> postUser(@RequestBody @Valid UserDTORequest userDTORequest){

        UserDTOResponse userDTOResponse = userService.postUser(userDTORequest);

        if(userDTOResponse == null){
            return ResponseEntity.badRequest().body("This User has register in the system");
        }

        return new ResponseEntity<UserDTOResponse>(userDTOResponse, HttpStatus.CREATED);
    }

    @GetMapping("/user/{cpf}")
    public ResponseEntity<?> getUser(@PathVariable("cpf") String cpf){

        User user = this.userService.getUser(cpf);
        if(user == null){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(user);
    }

    @GetMapping("/users")
    public ResponseEntity<?> getAllUsers(){
        List<User> userList = this.userService.getAllUsers();
        return ResponseEntity.ok(userList);
    }
}
