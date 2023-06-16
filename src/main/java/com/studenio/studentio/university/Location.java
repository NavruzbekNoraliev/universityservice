package com.studenio.studentio.university;
import lombok.Getter;
import lombok.Setter;
import javax.persistence.Embeddable;

@Embeddable
@Getter
@Setter
public class Location {
    private String city;
    private String country;
}
