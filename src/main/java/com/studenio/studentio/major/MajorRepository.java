package com.studenio.studentio.major;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MajorRepository extends CrudRepository<Major, Long> {
}
