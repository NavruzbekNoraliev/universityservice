package com.studenio.studentio.department;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/departments")
public class DepartmentController {

    private final DepartmentService departmentService;

    @Autowired
    public DepartmentController(DepartmentService departmentService) {
        this.departmentService = departmentService;
    }

    private DepartmentRepository departmentRepository;

    @GetMapping("/")
    public List<Department> getAllDepartments() {
        return departmentService.getAllDepartments();
    }

    @PostMapping("/")
    public Department createDepartment(@RequestBody Department department) {
        return departmentService.createDepartment(department);
    }

    @GetMapping("/{id}")
    public Department getDepartmentById(@PathVariable Long id) {
        return departmentService.getDepartmentById(id)
                .orElseThrow(() -> new IllegalArgumentException("Department not found with id: " + id));
    }


    @PutMapping("/{id}")
    public Department updateDepartment(@PathVariable String id, @RequestBody Department updatedDepartment) {
      return departmentService.updateDepartment(updatedDepartment);
    }

    @DeleteMapping("/{id}")
    public void deleteDepartment(@PathVariable Long id) {
        departmentService.deleteDepartment(id);
    }
}
