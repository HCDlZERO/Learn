package com.example.Learn;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentService {

    // ประกาศตัวแปร private final ชนิด StudentRepository เพื่อเก็บ reference ไปยัง repository
    private final StudentRepository studentRepository;

    // Constructor: รับ StudentRepository เป็น parameter เพื่อทำ dependency injection
    public StudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    // Method getAllStudents(): นำข้อมูลทั้งหมดจาก repository และ return เป็น List<Student>
    public List<Student> getAllStudents() {
        return studentRepository.findAll();
    }

    // Method getStudentById(String id): ค้นหา Student จาก repository ตาม ID และ return ผลลัพธ์
    public Student getStudentById(String id) {
        return studentRepository.findById(id).orElse(null);
    }

    // Method saveStudent(Student student): บันทึก Student ลงใน repository และ return Student ที่ถูกบันทึก
    public Student saveStudent(Student student) {
        return studentRepository.save(student);
    }

    // Method updateStudent(String id, Student updatedStudent): อัปเดต Student ตาม ID และ return Student ที่ถูกอัปเดต
    public Student updateStudent(String id, Student updatedStudent) {
        // ค้นหา Student จาก repository ตาม ID
        Student existingStudent = studentRepository.findById(id).orElse(null);
        
        // ถ้าพบ Student ที่ต้องการอัปเดต
        if (existingStudent != null) {
            // คัดลอก properties จาก updatedStudent ไปยัง existingStudent (ยกเว้น id)
            BeanUtils.copyProperties(updatedStudent, existingStudent, "id");
            // บันทึก existingStudent ที่ถูกอัปเดตลงใน repository
            return studentRepository.save(existingStudent);
        }
        // ถ้าไม่พบ Student ที่ต้องการอัปเดต จะ return null หรือจัดการ error ตามที่ต้องการ
        return null;
    }

    // Method deleteStudent(String id): ลบ Student จาก repository ตาม ID
    public void deleteStudent(String id) {
        studentRepository.deleteById(id);
    }
}
