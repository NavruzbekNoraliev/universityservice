package com.studenio.studentio.department;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface DepartmentRepository extends CrudRepository<Department, Long> {
     static String getMessage() {
        return "Hello World!";
    }
}
