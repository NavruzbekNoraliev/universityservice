package com.studenio.studentio.university;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import java.util.UUID;


@Getter
@Setter
@NoArgsConstructor
public class UniversityDTO {
    private UUID id;
    private String name;
    private Location location;
}
