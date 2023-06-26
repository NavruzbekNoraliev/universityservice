package com.studenio.studentio.university;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/universities")
public class UniversityController {

    private final UniversityService universityService;
    @Autowired
    public UniversityController(UniversityService universityService) {
        this.universityService = universityService;
    }

    @GetMapping("/")
    public List<University> getAllUniversities() {
        return universityService.getAllUniversities();
    }

    @PostMapping("/")
    public University createUniversity(@RequestBody University university) {
        return universityService.createUniversity(university);
    }

    @GetMapping("/{id}")
    public University getUniversityById(@PathVariable UUID id) {
        return universityService.getUniversityById(id)
                .orElseThrow(() -> new IllegalArgumentException("University not found with id: " + id));
    }

    @PutMapping("/{id}")
    public University updateUniversity(@PathVariable UUID id, @RequestBody University updatedUniversity) {
        University university = universityService.getUniversityById(id)
                .orElseThrow(() -> new IllegalArgumentException("University not found with id: " + id));

        university.setName(updatedUniversity.getName());
        university.setLocation(updatedUniversity.getLocation());
        university.setEstablishedYear(updatedUniversity.getEstablishedYear());
        university.setWebsite(updatedUniversity.getWebsite());

        return universityService.updateUniversity(university);
    }

    @DeleteMapping("/{id}")
    public void deleteUniversity(@PathVariable UUID id) {
        universityService.deleteUniversity(id);
    }
}
