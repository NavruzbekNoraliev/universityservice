package com.studenio.studentio.university;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
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

    @ApiOperation(value = "Create a new university", notes = "Create a new university")
    @ApiResponses(value = {
            @ApiResponse(code = 201, message = "University created", response = University.class)
    })
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

    private UniversityDTO convertToDTO(University university) {
        UniversityDTO dto = new UniversityDTO();
        dto.setId(university.getId());
        dto.setName(university.getName());
        dto.setLocation(university.getLocation());
        return dto;
    }

    @DeleteMapping("/{id}")
    public void deleteUniversity(@PathVariable UUID id) {
        universityService.deleteUniversity(id);
    }
}
