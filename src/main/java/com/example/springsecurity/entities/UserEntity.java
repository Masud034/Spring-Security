package com.example.springsecurity.entities;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.UUID;

@AllArgsConstructor
@NoArgsConstructor
@ToString
@EqualsAndHashCode
@Getter
@Setter
@Entity
public class UserEntity {

    @Id
    @GeneratedValue
    private UUID id;

    private String userId;

    private String firstName;

    private String lastName;

    private String email;

    private String encryptedPassword;
}
