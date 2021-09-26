package com.shoppcrypto.shoppcrypto.business;


import com.shoppcrypto.shoppcrypto.dto.UserDto;
import com.shoppcrypto.shoppcrypto.form.UserForm;
import com.shoppcrypto.shoppcrypto.model.User;

import java.util.Optional;
import java.util.UUID;

public interface UserBusinessService {

    public Optional<UserDto> registerNewUserAccount(final UserForm accountForm);

    public Optional<UserDto> getUser(UUID id);
}
