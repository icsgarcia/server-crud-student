package com.ivangarcia.studentmanagementsystem;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("students")
public class StudentController {

    private final StudentService studentService;

    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @GetMapping
    public List<StudentResponseDTO> getAllStudents() {
        return studentService.getAllStudents();
    }

    @GetMapping("{id}")
    public StudentResponseDTO getStudentById(@PathVariable Integer id) {
        return studentService.getStudentById(id);
    }

    @GetMapping("/search")
    public List<StudentResponseDTO> getStudentsByName(@RequestParam String keyword) {
        return studentService.getStudentByName(keyword);
    }

    @PostMapping
    public void addStudent(@RequestBody StudentRequestDTO student) {
        studentService.addStudent(student);
    }

    @PatchMapping("{id}")
    public void updateStudent(@PathVariable Integer id, @RequestBody StudentRequestDTO student) {
        studentService.updateStudent(id, student);
    }

    @DeleteMapping("{id}")
    public void deleteStudentById(@PathVariable Integer id) {
        studentService.deleteStudentById(id);
    }
}
