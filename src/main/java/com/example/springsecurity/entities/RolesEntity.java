package com.example.springsecurity.entities;

import lombok.*;

import javax.persistence.*;
import java.util.Collection;
import java.util.UUID;

@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
@Getter
@Setter
@Entity
@Table(name="roles")
public class RolesEntity {

    @Id
    @GeneratedValue
    private UUID id;

    @Column(nullable = false)
    private String name;

    @ManyToMany(mappedBy="roles")
    private Collection<UserEntity> users;

    @ManyToMany(cascade= { CascadeType.PERSIST }, fetch = FetchType.EAGER )
    @JoinTable(name="roles_authorities",
            joinColumns=@JoinColumn(name="roles_id",referencedColumnName="id"),
            inverseJoinColumns=@JoinColumn(name="authorities_id",referencedColumnName="id"))
    private Collection<AuthorityEntity> authorities;
}
