package com.codingshuttle.youtube.LearningRESTAPIs.service.impl;

import java.util.List;
import java.util.Map;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import com.codingshuttle.youtube.LearningRESTAPIs.dto.AddTeacherRequestDto;
import com.codingshuttle.youtube.LearningRESTAPIs.dto.StudentDto;
import com.codingshuttle.youtube.LearningRESTAPIs.dto.TeacherDto;
import com.codingshuttle.youtube.LearningRESTAPIs.entity.Student;
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

    @Override
    public void deleteTeacherById(Long id) {
        if(!teacherRepository.existsById(id)) {
            throw new IllegalArgumentException("Teacher does not exists by id: "+id);
        }
        teacherRepository.deleteById(id);
    }

    @Override
    public TeacherDto updatePartialTeacher(Long id, Map<String, Object> updates) {
         Teacher teacher = teacherRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Teacher not found with ID: "+id));

        updates.forEach((field, value) -> {
            switch (field) {
                case "name":
                    teacher.setName((String) value);
                    break;
                case "email":
                    teacher.setEmail((String) value);
                    break;
                default:
                    throw new IllegalArgumentException("Field is not supported");
            }
        });
        Teacher savedTeacher = teacherRepository.save(teacher);
        return modelMapper.map(savedTeacher, TeacherDto.class);
    }
}