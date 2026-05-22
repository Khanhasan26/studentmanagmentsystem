package com.codingshuttle.youtube.LearningRESTAPIs.dto;



import com.codingshuttle.youtube.LearningRESTAPIs.entity.type.Department;
import com.codingshuttle.youtube.LearningRESTAPIs.entity.type.Subjects;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TeacherDto {
    private Long id;
    private String name;
    private String email;
    private Subjects subject;
    private Department department;
    
}
