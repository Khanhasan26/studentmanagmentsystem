package com.codingshuttle.youtube.LearningRESTAPIs.service.impl;

import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import com.codingshuttle.youtube.LearningRESTAPIs.dto.AddTeacherRequestDto;
import com.codingshuttle.youtube.LearningRESTAPIs.dto.TeacherDto;
import com.codingshuttle.youtube.LearningRESTAPIs.entity.Teacher;
import com.codingshuttle.youtube.LearningRESTAPIs.repository.TeacherRepository;
import com.codingshuttle.youtube.LearningRESTAPIs.service.TeacherService;


import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class TeacherServiceImpl implements TeacherService {

    private final TeacherRepository teacherRepository;
    private final ModelMapper modelMapper;

    @Override
    public List<TeacherDto> getAllTeachers() {
         List<Teacher>teachers = teacherRepository.findAll();
            return teachers
                    .stream()
                    .map(teacher -> modelMapper.map(teacher, TeacherDto.class))
                    .toList();
    }

    @Override
    public TeacherDto createNewTeacher(AddTeacherRequestDto addTeacherRequestDto) {
        Teacher newTeacher = modelMapper.map(addTeacherRequestDto, Teacher.class);
        Teacher teacher = teacherRepository.save(newTeacher);
        return modelMapper.map(teacher, TeacherDto.class);
    }
    
}
