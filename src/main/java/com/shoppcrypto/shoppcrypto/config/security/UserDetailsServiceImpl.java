package com.shoppcrypto.shoppcrypto.config.security;

import com.shoppcrypto.shoppcrypto.model.User;
import com.shoppcrypto.shoppcrypto.persistence.repository.UserRepository;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {


    private final UserRepository userRepository;

    public UserDetailsServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<User> optionalUser = userRepository.findByEmail(username);

        if(optionalUser.isEmpty()){
            throw new UsernameNotFoundException("User "+username+" not found");
        }
        return new UserDetailsImpl(optionalUser);
    }
}
