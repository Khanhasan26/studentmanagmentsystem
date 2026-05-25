package com.codingshuttle.youtube.LearningRESTAPIs.service;

import java.util.List;
import java.util.Map;

import com.codingshuttle.youtube.LearningRESTAPIs.dto.AddTeacherRequestDto;
import com.codingshuttle.youtube.LearningRESTAPIs.dto.TeacherDto;


public interface TeacherService {

	List<TeacherDto> getAllTeachers();

    TeacherDto createNewTeacher(AddTeacherRequestDto addTeacherRequestDto);

    void deleteTeacherById(Long id);

	TeacherDto updatePartialTeacher(Long id, Map<String, Object> updates);
    
}
