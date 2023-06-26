package com.studenio.studentio.university;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface UniversityRepository extends CrudRepository<University, UUID> {
}
