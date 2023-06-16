package com.studenio.studentio.degree;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/degrees")
public class DegreeController {

    @Autowired
    private DegreeRepository degreeRepository;

    @GetMapping("/")
    public List<Degree> getAllDegrees() {
        return degreeRepository.findAll();
    }

    @PostMapping("/")
    public Degree createDegree(@RequestBody Degree degree) {
        return degreeRepository.save(degree);
    }

    @GetMapping("/{id}")
    public Degree getDegreeById(@PathVariable Long id) {
        return degreeRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Degree not found with id: " + id));
    }

    @PutMapping("/{id}")
    public Degree updateDegree(@PathVariable Long id, @RequestBody Degree updatedDegree) {
        Degree degree = degreeRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Degree not found with id: " + id));

        degree.setName(updatedDegree.getName());
        degree.setLevel(updatedDegree.getLevel());

        return degreeRepository.save(degree);
    }

    @DeleteMapping("/{id}")
    public void deleteDegree(@PathVariable Long id) {
        degreeRepository.deleteById(id);
    }
}
