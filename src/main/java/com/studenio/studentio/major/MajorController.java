package com.studenio.studentio.major;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/majors")
public class MajorController {

    @Autowired
    private MajorRepository majorRepository;

    @GetMapping("/")
    public List<Major> getAllMajors() {
        return majorRepository.findAll();
    }

    @PostMapping("/")
    public Major createMajor(@RequestBody Major major) {
        return majorRepository.save(major);
    }

    @GetMapping("/{id}")
    public Major getMajorById(@PathVariable Long id) {
        return majorRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Major not found with id: " + id));
    }

    @PutMapping("/{id}")
    public Major updateMajor(@PathVariable Long id, @RequestBody Major updatedMajor) {
        Major major = majorRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Major not found with id: " + id));

        major.setName(updatedMajor.getName());
        major.setDepartment(updatedMajor.getDepartment());

        return majorRepository.save(major);
    }

    @DeleteMapping("/{id}")
    public void deleteMajor(@PathVariable Long id) {
        majorRepository.deleteById(id);
    }
}
