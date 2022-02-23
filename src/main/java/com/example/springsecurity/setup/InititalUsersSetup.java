package com.example.springsecurity.setup;

import com.example.springsecurity.entities.AuthorityEntity;
import com.example.springsecurity.repositories.AuthorityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.ApplicationEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

@Component
public class InititalUsersSetup {

    @Autowired
    private AuthorityRepository authorityRepository;

    @EventListener
    public void onApplicationEvent(ApplicationReadyEvent applicationReadyEvent) {
        AuthorityEntity readAuthority = createAuthority("READ_AUTHORITY");
        AuthorityEntity writeAuthority = createAuthority("WRITE_AUTHORITY");
        AuthorityEntity deleteAuthority = createAuthority("DELETE_AUTHORITY");

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
}
