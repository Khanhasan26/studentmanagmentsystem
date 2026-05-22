package com.codingshuttle.youtube.LearningRESTAPIs.dto;


import com.codingshuttle.youtube.LearningRESTAPIs.entity.type.Department;
import com.codingshuttle.youtube.LearningRESTAPIs.entity.type.Subjects;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class AddTeacherRequestDto {
    @NotBlank(message = "Name is required")
    @Size(min = 3, max = 30, message = "Name should be of length 3 to 30 characters")
    private String name;

    @Email
    @NotBlank(message = "Email is Required")
    private String email;

    private Subjects subject;

    private Department department;
}
