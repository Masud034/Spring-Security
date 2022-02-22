package com.example.springsecurity.model;

import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@Getter
@Setter
public class UserResponseModel {

    private UUID id;

    private String userId;

    private String firstName;

    private String lastName;

    private String email;
}
