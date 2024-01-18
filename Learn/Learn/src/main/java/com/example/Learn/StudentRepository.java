package com.example.Learn;

import org.springframework.data.mongodb.repository.MongoRepository;

// Interface StudentRepository สืบทอดจาก MongoRepository ที่มี Entity เป็น Student และ ID เป็น String
public interface StudentRepository extends MongoRepository<Student, String> {
    // สามารถเพิ่มเมธอดสำหรับการค้นหาและจัดการข้อมูลเพิ่มเติมได้
}
