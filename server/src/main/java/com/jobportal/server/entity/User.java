package com.jobportal.server.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false)
    private String firstName;
    @Column(nullable = false)
    private String lastName;
    @Column(nullable = false , unique = true)
    private String email;
    @Column(nullable = false)
    private String dob;
    @Column(nullable = false)
    private String gender;
    @Column(nullable = false)
    private String mobile;
    @Column(nullable = false)
    private String password;
    @Column(nullable = false)
    private String address;

    @Column(nullable = false)
    private String about;

}
