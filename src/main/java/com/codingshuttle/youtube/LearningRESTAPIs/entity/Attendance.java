package com.codingshuttle.youtube.LearningRESTAPIs.entity;

import java.time.LocalDate;

import com.codingshuttle.youtube.LearningRESTAPIs.entity.type.AttendanceStatus;
import com.codingshuttle.youtube.LearningRESTAPIs.entity.type.Department;
import com.codingshuttle.youtube.LearningRESTAPIs.entity.type.Subjects;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Attendance {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private LocalDate date;

    @Enumerated(EnumType.STRING)
    private AttendanceStatus status;

    
    private Subjects subject;

    private Department department;
    
}
