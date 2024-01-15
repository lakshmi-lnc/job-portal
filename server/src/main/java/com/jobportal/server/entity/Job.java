package com.jobportal.server.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
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
@Table(name="job")
public class Job {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false)
    private String title;

    @Column(nullable = false)
    private String experience;

    @Column(nullable = false)
    private String location;
    @Column(nullable = false)
    private String department;

    @Column(nullable = false)
    private String salaryRange;
    @Column(nullable = false)
    private String employmentType;

    @Column(nullable = false)
    private String Education;
    @Column(nullable = false)
    private String skills;

    @Column(nullable = false)
    private String hrName;

    @Column(nullable = false)
    private String hrEmail;

    @Column(nullable = false, length=10000)
    private String description;
    @JsonIgnore
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "company_id")
    private Company company;
}
