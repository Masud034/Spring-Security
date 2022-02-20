package com.example.springsecurity.model;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@ToString
@EqualsAndHashCode
@Getter
@Setter
public class UserRequestModel {

    private String userId;

    private String firstName;

    private String lastName;

    private String email;

    private String rawPassword;
}
