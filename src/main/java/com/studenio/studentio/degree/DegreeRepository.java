package com.studenio.studentio.degree;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface DegreeRepository extends CrudRepository<Degree, UUID> {

}
