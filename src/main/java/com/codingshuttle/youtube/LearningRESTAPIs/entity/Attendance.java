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
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Attendance {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private LocalDate date;

    @Enumerated(EnumType.STRING)
    private AttendanceStatus status;
    
    @ManyToOne
    private Student student;

    @Enumerated(EnumType.STRING)
    private Subjects subject;

    @Enumerated(EnumType.STRING)
    private Department department;
    
}
