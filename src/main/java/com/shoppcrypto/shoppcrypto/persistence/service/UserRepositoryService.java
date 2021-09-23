package com.shoppcrypto.shoppcrypto.persistence.service;

import com.shoppcrypto.shoppcrypto.dto.UserDto;
import com.shoppcrypto.shoppcrypto.model.User;

import java.util.Optional;

public interface UserRepositoryService {
    Optional<User> save(User user);

    Optional<UserDto> findDtoById(Long id);
}
