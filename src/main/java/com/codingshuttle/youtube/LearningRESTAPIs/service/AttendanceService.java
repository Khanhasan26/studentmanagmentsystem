package com.codingshuttle.youtube.LearningRESTAPIs.service;



import org.springframework.stereotype.Service;

import com.codingshuttle.youtube.LearningRESTAPIs.dto.AttendanceDto;
import com.codingshuttle.youtube.LearningRESTAPIs.dto.MarkAttendanceRequestDto;

@Service
public interface AttendanceService {

    AttendanceDto markAttendance(MarkAttendanceRequestDto markAttendanceRequestDtos);
    
}
