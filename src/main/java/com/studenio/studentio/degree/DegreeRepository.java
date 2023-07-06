package com.studenio.studentio.degree;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.UUID;

@Repository
public interface DegreeRepository extends JpaRepository<Degree, UUID> {

}
