package com.studenio.studentio.degree;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class DegreeService {

    private final DegreeRepository degreeRepository;

    @Autowired
    public DegreeService(DegreeRepository degreeRepository) {
        this.degreeRepository = degreeRepository;
    }

    public List<Degree> getAllDegrees() {
        return (List<Degree>) degreeRepository.findAll();
    }

    public Optional<Degree> getDegreeById(UUID id) {
        return degreeRepository.findById(id);
    }

    public Degree createDegree(Degree degree) {
        return degreeRepository.save(degree);
    }

    public Degree updateDegree(Degree degree) {
        return degreeRepository.save(degree);
    }

    public void deleteDegree(UUID id) {
        degreeRepository.deleteById(id);
    }
}
