package com.shoppcrypto.shoppcrypto.controller;


import com.shoppcrypto.shoppcrypto.dto.UserDto;
import com.shoppcrypto.shoppcrypto.form.UserForm;
import com.shoppcrypto.shoppcrypto.model.User;
import com.shoppcrypto.shoppcrypto.persistence.service.UserRepositoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import javax.transaction.Transactional;
import java.net.URI;
import java.util.Optional;

@RestController()
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserRepositoryService userRepositoryService;

    private static final String path = "/users/{id}";

    @PostMapping
    @Transactional
    private ResponseEntity<UserDto> saveUser(@RequestBody UserForm userForm, UriComponentsBuilder uriBuilder){
        User user = new User(userForm);
        Optional<User>  optionalUser = userRepositoryService.save(user);

        if(optionalUser.isPresent()){
            URI uri = uriBuilder.path(path).buildAndExpand(optionalUser.get().getId()).toUri();

            return ResponseEntity.created(uri).body(new UserDto(optionalUser.get()));
        }
        return ResponseEntity.badRequest().build();
    }

    @GetMapping("/{id}")
    private ResponseEntity<UserDto> getUser (@PathVariable Long id){
        Optional<UserDto> optionalUserDto= userRepositoryService.findDtoById(id);
        if(optionalUserDto.isPresent()){
            return ResponseEntity.ok(optionalUserDto.get());
        }
        return ResponseEntity.notFound().build();
    }

}
