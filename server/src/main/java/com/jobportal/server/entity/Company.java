package com.jobportal.server.entity;


import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="company")
public class Company {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false)
    private String companyName;
    @Column(nullable = false)
    private String type;
    @Column(nullable = false , unique = true)
    private String foundedOn;
    @Column(nullable = false)
    private String companySize;
    @Column(nullable = false)
    private String website;
    @Column(nullable = false)
    private String headquarter;
    @Column(nullable = false)
    private String username;
    @Column(nullable = false)
    private String password;
    @Column(nullable = false)
    private String address;

    @Column(nullable = false, length = 5000)
    private String about;
    @JsonIgnore
@OneToMany(fetch = FetchType.LAZY, mappedBy = "company",cascade = CascadeType.ALL)
    private List<Job> jobs;
}
