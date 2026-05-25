package com.codingshuttle.youtube.LearningRESTAPIs.controller;



import java.util.List;
import java.util.Map;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.codingshuttle.youtube.LearningRESTAPIs.dto.AttendanceDto;
import com.codingshuttle.youtube.LearningRESTAPIs.dto.MarkAttendanceRequestDto;
import com.codingshuttle.youtube.LearningRESTAPIs.dto.StudentDto;
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

    @GetMapping
    public ResponseEntity<List<AttendanceDto>> getAllAttendances() {
//        return ResponseEntity.status(HttpStatus.OK).body(studentService.getAllStudents());
        return ResponseEntity.ok(attendanceService.getAllAttendances());
    }


    @PatchMapping("/{id}")
    public ResponseEntity<AttendanceDto> updatePartialAttendance(@PathVariable Long id,
                                                           @RequestBody Map<String, Object> updates) {
        return ResponseEntity.ok(attendanceService.updatePartialAttendance(id, updates));
    }

    
}
