package com.studenio.studentio.degree;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.studenio.studentio.university.University;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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

    public Page<Degree> getAllDegrees(Pageable pageable) {
        Page<Degree> degreePage = degreeRepository.findAll(pageable);
        return degreePage;
    }

    public Optional<Degree> getDegreeById(UUID id) {
        return degreeRepository.findById(id);
    }

    public Degree createDegree(Degree degree) {
        return degreeRepository.save(degree);
    }

    public Degree updateDegree(UUID id, Degree degreeDto) {
        Degree degreeOriginal = findById(id).get();
        ObjectMapper objectMapper = new ObjectMapper();
        degreeDto -> degreeOriginal
        return degreeRepository.save(degreeOriginal);
    }

    public void deleteDegree(UUID id) {
        degreeRepository.deleteById(id);
    }
}
