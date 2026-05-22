package com.codingshuttle.youtube.LearningRESTAPIs.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.codingshuttle.youtube.LearningRESTAPIs.entity.Attendance;

public interface AttendanceRepository extends JpaRepository<Attendance, Long> {
    
}
