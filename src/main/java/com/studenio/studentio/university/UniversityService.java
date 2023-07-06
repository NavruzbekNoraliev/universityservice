package com.studenio.studentio.university;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class UniversityService {
    private final UniversityRepository universityRepository;
    @Autowired
    public UniversityService(UniversityRepository universityRepository) {
        this.universityRepository = universityRepository;
    }

    @Cacheable(value = "universityCache", key = "#university.id")
    public University createUniversity(University university) {
        return universityRepository.save(university);
    }

    @Cacheable(value = "universityCache", key = "#id")
    public Optional<University> getUniversityById(UUID id) {
        return universityRepository.findById(id);
    }

    @Cacheable(value = "universityCache", key = "'allUniversities'")
    public List<University> getAllUniversities() {
        return (List<University>) universityRepository.findAll();
    }

    @CachePut(value = "universityCache", key = "#university.id")
    public University updateUniversity(University university) {
        return universityRepository.save(university);
    }

    @CacheEvict(value = "universityCache", key = "#id")
    public void deleteUniversity(UUID id) {
        universityRepository.deleteById(id);
    }
}
