package com.shoppcrypto.shoppcrypto.controller;


import com.shoppcrypto.shoppcrypto.business.UserBusinessService;
import com.shoppcrypto.shoppcrypto.dto.UserDto;
import com.shoppcrypto.shoppcrypto.form.UserForm;
import com.shoppcrypto.shoppcrypto.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import javax.transaction.Transactional;
import java.net.URI;
import java.util.Optional;
import java.util.UUID;

@RestController()
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserBusinessService userBusinessService;

    private static final String path = "/users/{id}";

    @PostMapping("/registration")
    @Transactional
    private ResponseEntity<UserDto> saveUser(@RequestBody UserForm userForm, UriComponentsBuilder uriBuilder){

        Optional<UserDto> optionalUser = userBusinessService.registerNewUserAccount(userForm);

        if(optionalUser.isPresent()){
            URI uri = uriBuilder.path(path).buildAndExpand(optionalUser.get().getId()).toUri();
            return ResponseEntity.created(uri).body(optionalUser.get());
        }
        return ResponseEntity.badRequest().build();
    }

    @GetMapping("/{id}")
    private ResponseEntity<UserDto> getUser (@PathVariable UUID id){
        Optional<UserDto> optionalUserDto= userBusinessService.getUser(id);
        if(optionalUserDto.isPresent()){
            return ResponseEntity.ok(optionalUserDto.get());
        }
        return ResponseEntity.notFound().build();
    }

}
