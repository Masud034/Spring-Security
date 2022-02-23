package com.example.springsecurity.entities;

import lombok.*;

import javax.persistence.*;
import java.util.Collection;
import java.util.UUID;

@AllArgsConstructor
@NoArgsConstructor
@ToString
@EqualsAndHashCode
@Getter
@Setter
@Entity
@Table(name="users")
public class UserEntity {

    @Id
    @GeneratedValue
    private UUID id;

    private String userId;

    private String firstName;

    private String lastName;

    private String email;

    private String encryptedPassword;

    @ManyToMany(cascade= { CascadeType.PERSIST }, fetch = FetchType.EAGER )
    @JoinTable(name="users_roles",
            joinColumns=@JoinColumn(name="users_id",referencedColumnName="id"))
    private Collection<RolesEntity> roles;
}
