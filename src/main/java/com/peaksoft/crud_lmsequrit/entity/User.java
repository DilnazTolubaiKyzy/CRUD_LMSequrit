package com.peaksoft.crud_lmsequrit.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "users")
@NoArgsConstructor
@AllArgsConstructor
@Getter@Setter
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Long age;
    private String username;
    @Column(name = "last_name")
    private String lastName;
    private String email;
    private String password;

    @ManyToMany(cascade = {CascadeType.MERGE,CascadeType.REFRESH},fetch = FetchType.EAGER)
    @JoinTable(name = "users_role",
            joinColumns = @JoinColumn(name = "user_id",referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "role_id",referencedColumnName = "id"))
    Set<Role> roles;

    @Transient
    private String roleName;
}
