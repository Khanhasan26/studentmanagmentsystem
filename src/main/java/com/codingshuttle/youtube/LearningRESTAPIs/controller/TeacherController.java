package com.codingshuttle.youtube.LearningRESTAPIs.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.codingshuttle.youtube.LearningRESTAPIs.dto.AddTeacherRequestDto;
import com.codingshuttle.youtube.LearningRESTAPIs.dto.TeacherDto;
import com.codingshuttle.youtube.LearningRESTAPIs.service.TeacherService;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@RequestMapping("/teachers")
public class TeacherController {

    private final TeacherService teacherService;

    @GetMapping
    public ResponseEntity<List<TeacherDto>> getAllTeachers() {
        return ResponseEntity.ok(teacherService.getAllTeachers());
    }

    @PostMapping
    public ResponseEntity<TeacherDto> createNewTeacher(@RequestBody @Valid AddTeacherRequestDto addTeacherRequestDto) {
        return ResponseEntity.status(HttpStatus.CREATED).body(teacherService.createNewTeacher(addTeacherRequestDto));
    }
    
}
