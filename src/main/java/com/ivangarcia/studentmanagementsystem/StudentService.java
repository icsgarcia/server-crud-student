package com.ivangarcia.studentmanagementsystem;

import jakarta.persistence.EntityNotFoundException;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentService {
    private final StudentRepository studentRepository;

    public StudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    public StudentResponseDTO mapToStudentResponseDTO(Student student) {
        return new StudentResponseDTO(
                student.getId(),
                student.getFirstName(),
                student.getLastName(),
                student.getCourse(),
                student.getYearLevel(),
                student.getEmail()
        );
    }

    public List<StudentResponseDTO> getAllStudents() {
        return studentRepository.findAll().stream().map(this::mapToStudentResponseDTO).toList();
    }

    public StudentResponseDTO getStudentById(Integer id) {
        return studentRepository.findById(id).map(this::mapToStudentResponseDTO).orElseThrow(() -> new RuntimeException("Student not found with id: " + id));
    }

    public void addStudent(StudentRequestDTO studentReq) {
        Student student = new Student();
        student.setFirstName(studentReq.getFirstName());
        student.setLastName(studentReq.getLastName());
        student.setEmail(studentReq.getEmail());
        student.setCourse(studentReq.getCourse());
        student.setYearLevel(studentReq.getYearLevel());
        studentRepository.save(student);
    }

    public void deleteStudentById(Integer id) {
        boolean studentExists = studentRepository.existsById(id);

        if (!studentExists) {
            throw new EntityNotFoundException("Student with id: " + id + " not found");
        }

        studentRepository.deleteById(id);
    }

    public void updateStudent(Integer id, StudentRequestDTO student) {
        Student existingStudent = studentRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("Student with id: " + id + " not found"));

        if (student.getFirstName() != null && !student.getFirstName().isBlank()) {
            existingStudent.setFirstName(student.getFirstName());
        }
        if (student.getLastName() != null && !student.getLastName().isBlank()) {
            existingStudent.setLastName(student.getLastName());
        }
        if (student.getEmail() != null && !student.getEmail().isBlank()) {
            existingStudent.setEmail(student.getEmail());
        }
        if (student.getCourse() != null && !student.getCourse().isBlank()) {
            existingStudent.setCourse(student.getCourse());
        }
        if (student.getYearLevel() != null && !student.getYearLevel().isBlank()) {
            existingStudent.setYearLevel(student.getYearLevel());
        }

        studentRepository.save(existingStudent);
    }

    public List<StudentResponseDTO> getStudentByName(String keyword) {
        return studentRepository.searchAll(keyword).stream().map(this::mapToStudentResponseDTO).toList();
    }
}
