package com.studenio.studentio.university;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
@Table(name = "university")
public class University {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @Embedded
    private Location location;

    @Column(name = "established_year")
    private int establishedYear;

    private String website;

    // Constructors, getters, and setters
}
