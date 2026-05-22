package com.codingshuttle.youtube.LearningRESTAPIs.controller;



import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.codingshuttle.youtube.LearningRESTAPIs.dto.AttendanceDto;
import com.codingshuttle.youtube.LearningRESTAPIs.dto.MarkAttendanceRequestDto;
import com.codingshuttle.youtube.LearningRESTAPIs.service.AttendanceService;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@RequestMapping("/attendance")
public class AttendanceController {
    
    private final AttendanceService attendanceService;

    

    @PostMapping
    public ResponseEntity<AttendanceDto> markAttendance(@RequestBody MarkAttendanceRequestDto markAttendanceRequestDtos) {
        return ResponseEntity.ok(attendanceService.markAttendance(markAttendanceRequestDtos));
    }

    
}
