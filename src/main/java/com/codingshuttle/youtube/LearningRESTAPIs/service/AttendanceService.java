package com.codingshuttle.youtube.LearningRESTAPIs.service;



import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.codingshuttle.youtube.LearningRESTAPIs.dto.AttendanceDto;
import com.codingshuttle.youtube.LearningRESTAPIs.dto.MarkAttendanceRequestDto;

@Service
public interface AttendanceService {

    AttendanceDto markAttendance(MarkAttendanceRequestDto markAttendanceRequestDtos);

    AttendanceDto updatePartialAttendance(Long id, Map<String, Object> updates);

    List<AttendanceDto> getAllAttendances();
    
}
