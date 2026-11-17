
package com.student.studentsystem.service;

import com.student.studentsystem.model.Student;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class StudentService {

    private final List<Student> students = new ArrayList<>();

    private int nextId = 1;

    // CREATE: Register student
    public Student addStudent(Student student) {

        Student newStudent = new Student(
            nextId++,
            student.getName(),
            student.getEmail(),
            student.getDepartment(),
            student.getYear()
        );

        students.add(newStudent);

        return newStudent;
    }

    // READ: Get all students
    public List<Student> getAllStudents() {

        return students;
    }

    // UPDATE: Update student
    public Student updateStudent(int id, Student updatedStudent) {

        for (Student student : students) {

            if (student.getId() == id) {

                student.setName(updatedStudent.getName());
                student.setEmail(updatedStudent.getEmail());
                student.setDepartment(updatedStudent.getDepartment());
                student.setYear(updatedStudent.getYear());

                return student;
            }
        }

        return null;
    }

    // DELETE: Remove student
    public boolean deleteStudent(int id) {

        return students.removeIf(
            student -> student.getId() == id
        );
    }
}
