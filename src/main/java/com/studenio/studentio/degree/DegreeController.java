package com.studenio.studentio.degree;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RestController
@Log4j2
@RequestMapping("/degrees")
public class DegreeController {

    private final DegreeService degreeService;

    @Autowired
    public DegreeController(DegreeService degreeService) {
        this.degreeService = degreeService;
    }

    @GetMapping
    public List<Degree> getAllDegrees() {
        log.info("Getting all Degrees");
        return degreeService.getAllDegrees();
    }

    @GetMapping("/{id}")
    public Optional<Degree> getDegreeById(@PathVariable("id") UUID id) {
        return degreeService.getDegreeById(id);
    }

    @PostMapping
    public Degree createDegree(@RequestBody Degree degree) {
        return degreeService.createDegree(degree);
    }

    @PutMapping("/{id}")
    public Degree updateDegree(@PathVariable("id") UUID id, @RequestBody Degree degree) {
        degree.setId(id);
        return degreeService.updateDegree(degree);
    }

    @DeleteMapping("/{id}")
    public void deleteDegree(@PathVariable("id") UUID id) {
        degreeService.deleteDegree(id);
    }
}
