package com.shoppcrypto.shoppcrypto.business;

import com.shoppcrypto.shoppcrypto.dto.UserDto;
import com.shoppcrypto.shoppcrypto.form.UserForm;
import com.shoppcrypto.shoppcrypto.model.User;
import com.shoppcrypto.shoppcrypto.persistence.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Optional;
import java.util.UUID;

@Service
@Transactional
public class UserBusinessServiceImpl implements UserBusinessService{

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public Optional<UserDto> registerNewUserAccount(UserForm accountForm) {
        if (emailExists(accountForm.getEmail())) {
            throw new RuntimeException("There is an account with that email address: " + accountForm.getEmail());
        }
        final User user = new User(accountForm);

        user.setPassword(passwordEncoder.encode(user.getPassword()));

        Optional<User> optionalUser = Optional.ofNullable(userRepository.save(user));
        return Optional.ofNullable(new UserDto(optionalUser.get()));
    }

    @Override
    public Optional<UserDto> getUser(UUID id) {
        Optional<User> optionalUser = userRepository.findById(id);
        if(optionalUser.isPresent())
            return Optional.ofNullable(new UserDto(optionalUser.get()));

        return Optional.empty();
    }

    private boolean emailExists(final String email) {
        return userRepository.findByEmail(email).isPresent();
    }
}
