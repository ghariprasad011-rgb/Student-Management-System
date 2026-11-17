
package com.student.studentsystem.controller;

import com.student.studentsystem.model.Student;
import com.student.studentsystem.service.StudentService;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/students")
@CrossOrigin(origins = "*")
public class StudentController {

    private final StudentService studentService;

    public StudentController(StudentService studentService) {

        this.studentService = studentService;
    }

    // CREATE: Register student
    @PostMapping
    public Student addStudent(@RequestBody Student student) {

        return studentService.addStudent(student);
    }

    // READ: Get all students
    @GetMapping
    public List<Student> getAllStudents() {

        return studentService.getAllStudents();
    }

    // UPDATE: Update student
    @PutMapping("/{id}")
    public ResponseEntity<Student> updateStudent(
            @PathVariable int id,
            @RequestBody Student student) {

        Student updatedStudent =
            studentService.updateStudent(id, student);

        if (updatedStudent == null) {

            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok(updatedStudent);
    }

    // DELETE: Delete student
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteStudent(
            @PathVariable int id) {

        boolean deleted = studentService.deleteStudent(id);

        if (!deleted) {

            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.noContent().build();
    }
}
