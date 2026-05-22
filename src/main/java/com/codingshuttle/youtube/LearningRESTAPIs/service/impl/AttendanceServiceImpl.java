package com.codingshuttle.youtube.LearningRESTAPIs.service.impl;



import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import com.codingshuttle.youtube.LearningRESTAPIs.dto.AttendanceDto;
import com.codingshuttle.youtube.LearningRESTAPIs.dto.MarkAttendanceRequestDto;
import com.codingshuttle.youtube.LearningRESTAPIs.entity.Attendance;
import com.codingshuttle.youtube.LearningRESTAPIs.repository.AttendanceRepository;
import com.codingshuttle.youtube.LearningRESTAPIs.service.AttendanceService;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class AttendanceServiceImpl implements AttendanceService {

    private final AttendanceRepository attendanceRepository;
    private final ModelMapper modelmapper;



    @Override
    public AttendanceDto markAttendance(MarkAttendanceRequestDto markAttendanceRequestDtos) {
        Attendance newAttendance = modelmapper.map(markAttendanceRequestDtos, Attendance.class);
        Attendance attendance = attendanceRepository.save(newAttendance);
        return modelmapper.map(attendance, AttendanceDto.class);
       
        
    }
    
}
