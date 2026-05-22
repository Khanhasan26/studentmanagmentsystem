package com.codingshuttle.youtube.LearningRESTAPIs.service;

import java.util.List;

import com.codingshuttle.youtube.LearningRESTAPIs.dto.AddTeacherRequestDto;
import com.codingshuttle.youtube.LearningRESTAPIs.dto.TeacherDto;


public interface TeacherService {

	List<TeacherDto> getAllTeachers();

    TeacherDto createNewTeacher(AddTeacherRequestDto addTeacherRequestDto);
    
}
