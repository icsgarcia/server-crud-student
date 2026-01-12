package com.ivangarcia.studentmanagementsystem;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface StudentRepository extends JpaRepository<Student, Integer> {
    @Query("""
SELECT s FROM Student s
        WHERE
          LOWER(s.firstName) LIKE LOWER(CONCAT('%', :keyword, '%'))
          OR LOWER(s.lastName) LIKE LOWER(CONCAT('%', :keyword, '%'))
          OR LOWER(s.email) LIKE LOWER(CONCAT('%', :keyword, '%'))
          OR LOWER(s.course) LIKE LOWER(CONCAT('%', :keyword, '%'))
          OR LOWER(s.yearLevel) LIKE LOWER(CONCAT('%', :keyword, '%'))
""")
    List<Student> searchAll(@Param("keyword") String keyword);
}

