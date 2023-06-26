package com.studenio.studentio.course;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;


@Getter
@Setter
public class Course {
    @Id
    private String id;
    String title;
    int credit;
}
