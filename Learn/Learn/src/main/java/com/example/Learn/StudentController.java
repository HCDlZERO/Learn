package com.example.Learn;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/students")
public class StudentController {

    // ประกาศตัวแปร private final ชนิด StudentService เพื่อเก็บ reference ไปยัง service
    private final StudentService studentService;

    // Constructor: รับ StudentService เป็น parameter เพื่อทำ dependency injection
    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    // HTTP GET method ที่ให้ endpoint "/api/students" เพื่อดึงข้อมูลทั้งหมดของนักศึกษา
    @GetMapping
    public List<Student> getAllStudents() {
        return studentService.getAllStudents();
    }

    // HTTP GET method ที่ให้ endpoint "/api/students/{id}" เพื่อดึงข้อมูลของนักศึกษาตาม ID ที่ระบุ
    @GetMapping("/{id}")
    public Student getStudentById(@PathVariable String id) {
        return studentService.getStudentById(id);
    }

    // HTTP POST method ที่ให้ endpoint "/api/students" เพื่อบันทึกข้อมูล Student ใหม่
    @PostMapping
    public Student saveStudent(@RequestBody Student student) {
        return studentService.saveStudent(student);
    }

    // HTTP PUT method ที่ให้ endpoint "/api/students/{id}" เพื่ออัปเดตข้อมูลของนักศึกษาตาม ID ที่ระบุ
    @PutMapping("/{id}")
    public Student updateStudent(@PathVariable String id, @RequestBody Student updatedStudent) {
        return studentService.updateStudent(id, updatedStudent);
    }

    // HTTP DELETE method ที่ให้ endpoint "/api/students/{id}" เพื่อลบข้อมูลของนักศึกษาตาม ID ที่ระบุ
    @DeleteMapping("/{id}")
    public void deleteStudent(@PathVariable String id) {
        studentService.deleteStudent(id);
    }
}
