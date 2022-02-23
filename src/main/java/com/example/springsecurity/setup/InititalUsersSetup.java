package com.example.springsecurity.setup;

import com.example.springsecurity.entities.AuthorityEntity;
import com.example.springsecurity.entities.RolesEntity;
import com.example.springsecurity.entities.UserEntity;
import com.example.springsecurity.repositories.AuthorityRepository;
import com.example.springsecurity.repositories.RoleRepository;
import com.example.springsecurity.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.ApplicationEvent;
import org.springframework.context.event.EventListener;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;

import javax.transaction.Transactional;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

@Component
public class InititalUsersSetup {

    @Autowired
    private AuthorityRepository authorityRepository;

    @Autowired
    private RoleRepository roleRepository;

    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    @Autowired
    private UserRepository userRepository;

    @EventListener
    @Transactional
    public void onApplicationEvent(ApplicationReadyEvent applicationReadyEvent) {
        AuthorityEntity readAuthority = createAuthority("READ_AUTHORITY");
        AuthorityEntity writeAuthority = createAuthority("WRITE_AUTHORITY");
        AuthorityEntity deleteAuthority = createAuthority("DELETE_AUTHORITY");

        RolesEntity roleUser = createRole("ROLE_USER", Arrays.asList(readAuthority, writeAuthority));
        RolesEntity roleAdmin = createRole("ROLE_ADMIN", Arrays.asList(readAuthority, writeAuthority, deleteAuthority));

        UserEntity adminUser = new UserEntity();
        adminUser.setUserId("admin#1");
        adminUser.setFirstName("Masudul");
        adminUser.setLastName("Alam");
        adminUser.setEmail("masudulalam@gmail.com");
        adminUser.setEncryptedPassword(bCryptPasswordEncoder.encode("@admin#1#"));
        adminUser.setRoles(List.of(roleAdmin));

        System.out.println(userRepository.save(adminUser));


    }


    private AuthorityEntity createAuthority (String name) {
        AuthorityEntity authority = authorityRepository.findByName(name);
        if(authority == null) {
            authority = new AuthorityEntity();
            authority.setName(name);
            authorityRepository.save(authority);
        }

        return authority;
    }


    private RolesEntity createRole(String name, Collection<AuthorityEntity> authorities) {00

        RolesEntity role = roleRepository.findByName(name);
        if (role == null) {
            role = new RolesEntity();
            role.setName(name);
            role.setAuthorities(authorities);
            roleRepository.save(role);
        }
        return role;
    }
}
