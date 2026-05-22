package com.codingshuttle.youtube.LearningRESTAPIs.dto;

import java.time.LocalDate;
import com.codingshuttle.youtube.LearningRESTAPIs.entity.type.AttendanceStatus;
import com.codingshuttle.youtube.LearningRESTAPIs.entity.type.Department;
import com.codingshuttle.youtube.LearningRESTAPIs.entity.type.Subjects;
import lombok.Data;

@Data
public class MarkAttendanceRequestDto {

    private LocalDate date;

    private AttendanceStatus status;
    
    private Long studentId;

    private Subjects subject;

    private Department department;
    
}
