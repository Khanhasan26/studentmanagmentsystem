package com.codingshuttle.youtube.LearningRESTAPIs;


import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.codingshuttle.youtube.LearningRESTAPIs.entity.Student;
import com.codingshuttle.youtube.LearningRESTAPIs.repository.StudentRepository;

@SpringBootTest
public class StudentTest {

    @Autowired
    private StudentRepository studentRepository;

    @Test
    public void testStudentRepository(){

        List<Student> studentList = studentRepository.findAll();
        System.out.println(studentList);

    }
    
}
