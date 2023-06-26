package com.studenio.studentio.university;
import lombok.*;

import javax.persistence.Embeddable;

@Getter
@Setter
@Data
@Embeddable
public class Location {
    private String city;
    private String country;
    private String state;
    private String streetAddress;
    private String postalCode;
}
