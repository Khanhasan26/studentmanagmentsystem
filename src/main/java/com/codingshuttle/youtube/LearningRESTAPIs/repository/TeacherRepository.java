package com.codingshuttle.youtube.LearningRESTAPIs.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.codingshuttle.youtube.LearningRESTAPIs.entity.Teacher;

public interface TeacherRepository extends JpaRepository<Teacher, Long> {
    
}
