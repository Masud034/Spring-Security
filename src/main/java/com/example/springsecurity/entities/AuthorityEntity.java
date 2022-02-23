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
@Table(name="authorities")
public class AuthorityEntity {
    @Id
    @GeneratedValue
    private UUID id;

    @Column(nullable = false)
    private String name;

    @ManyToMany(mappedBy="authorities")
    private Collection<RolesEntity> roles;
}
