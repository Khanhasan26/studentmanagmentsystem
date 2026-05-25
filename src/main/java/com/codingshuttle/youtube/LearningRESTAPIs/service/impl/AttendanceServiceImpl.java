package com.codingshuttle.youtube.LearningRESTAPIs.service.impl;



import java.util.List;
import java.util.Map;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import com.codingshuttle.youtube.LearningRESTAPIs.dto.AttendanceDto;
import com.codingshuttle.youtube.LearningRESTAPIs.dto.MarkAttendanceRequestDto;
import com.codingshuttle.youtube.LearningRESTAPIs.entity.Attendance;
import com.codingshuttle.youtube.LearningRESTAPIs.entity.type.AttendanceStatus;
import com.codingshuttle.youtube.LearningRESTAPIs.entity.type.Department;
import com.codingshuttle.youtube.LearningRESTAPIs.entity.type.Subjects;
import com.codingshuttle.youtube.LearningRESTAPIs.repository.AttendanceRepository;
import com.codingshuttle.youtube.LearningRESTAPIs.service.AttendanceService;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class AttendanceServiceImpl implements AttendanceService {

    private final AttendanceRepository attendanceRepository;
    private final ModelMapper modelMapper;



    @Override
    public AttendanceDto markAttendance(MarkAttendanceRequestDto markAttendanceRequestDtos) {
        Attendance newAttendance = modelMapper.map(markAttendanceRequestDtos, Attendance.class);
        Attendance attendance = attendanceRepository.save(newAttendance);
        return modelMapper.map(attendance, AttendanceDto.class);
       
        
    }

    @Override
    public AttendanceDto updatePartialAttendance(Long id, Map<String, Object> updates) {
        Attendance attendance = attendanceRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Attendance not found with ID: "+id));

        updates.forEach((field, value) -> {
            switch (field) {
                case "status":
            attendance.setStatus(
                AttendanceStatus.valueOf(value.toString())
            );
            break;

        case "subject":
            attendance.setSubject(
                Subjects.valueOf(value.toString())
            );
            break;

        case "department":
            attendance.setDepartment(
                Department.valueOf(value.toString())
            );
            break;

                default:
                    throw new IllegalArgumentException("Field is not supported");
            }
        });
        Attendance savedAttendance = attendanceRepository.save(attendance);
        return modelMapper.map(savedAttendance, AttendanceDto.class);
    }

    @Override
    public List<AttendanceDto> getAllAttendances() {
         List<Attendance>attendances = attendanceRepository.findAll();
            return attendances
                    .stream()
                    .map(attendance -> modelMapper.map(attendance, AttendanceDto.class))
                    .toList();
    }
    
    
}
