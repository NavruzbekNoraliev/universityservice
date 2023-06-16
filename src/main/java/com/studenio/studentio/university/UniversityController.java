package com.studenio.studentio.university;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/universities")
public class UniversityController {

    @Autowired
    private UniversityRepository universityRepository;

    @GetMapping("/")
    public List<University> getAllUniversities() {
        return universityRepository.findAll();
    }

    @PostMapping("/")
    public University createUniversity(@RequestBody University university) {
        return universityRepository.save(university);
    }

    @GetMapping("/{id}")
    public University getUniversityById(@PathVariable Long id) {
        return universityRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("University not found with id: " + id));
    }

    @PutMapping("/{id}")
    public University updateUniversity(@PathVariable Long id, @RequestBody University updatedUniversity) {
        University university = universityRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("University not found with id: " + id));

        university.setName(updatedUniversity.getName());
        university.setLocation(updatedUniversity.getLocation());
        university.setEstablishedYear(updatedUniversity.getEstablishedYear());
        university.setWebsite(updatedUniversity.getWebsite());

        return universityRepository.save(university);
    }

    @DeleteMapping("/{id}")
    public void deleteUniversity(@PathVariable Long id) {
        universityRepository.deleteById(id);
    }
}
