package com.example.springsecurity.services;

import com.example.springsecurity.entities.UserEntity;
import com.example.springsecurity.model.UserRequestModel;
import com.example.springsecurity.repositories.UserRepository;
import com.example.springsecurity.security.UserPrincipal;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class UserService implements UserDetailsService {

    @Autowired
    private BCryptPasswordEncoder passwordEncoder;

    @Autowired
    private UserRepository userRepository;

    public UserEntity addUser (UserRequestModel userRequest) {
        UserEntity userEntity = new UserEntity();

        BeanUtils.copyProperties(userRequest, userEntity);
        userEntity.setEncryptedPassword(passwordEncoder.encode(userRequest.getRawPassword()));

        return userRepository.save(userEntity);
    }

    public UserEntity getUserByUserName(String userName) {
        return userRepository.findByEmail(userName);
    }

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        UserEntity userEntity = userRepository.findByEmail(email);
        if(userEntity == null) throw new UsernameNotFoundException(email);

        return new UserPrincipal(userEntity);
    }


}
