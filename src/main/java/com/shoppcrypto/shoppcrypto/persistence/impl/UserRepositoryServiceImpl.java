package com.shoppcrypto.shoppcrypto.persistence.impl;

import com.shoppcrypto.shoppcrypto.dto.UserDto;
import com.shoppcrypto.shoppcrypto.model.User;
import com.shoppcrypto.shoppcrypto.persistence.repository.UserRepository;
import com.shoppcrypto.shoppcrypto.persistence.service.UserRepositoryService;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public class UserRepositoryServiceImpl implements UserRepositoryService {
    private UserRepository userRepository;

    public UserRepositoryServiceImpl(UserRepository userRepository){
        this.userRepository = userRepository;
    }
    @Override
    public Optional<User> save(User user) {
        return Optional.ofNullable(userRepository.save(user));
    }

    @Override
    public Optional<UserDto> findDtoById(UUID id) {
        Optional<User> optionalUser = userRepository.findById(id);
        if(optionalUser.isPresent())
            return Optional.ofNullable(new UserDto(optionalUser.get()));

        return Optional.empty();
    }
}
