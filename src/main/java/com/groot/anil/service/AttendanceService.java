package com.groot.anil.service;

import com.groot.anil.entity.Attendance;
import com.groot.anil.repository.AttendanceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AttendanceService {

    private final AttendanceRepository attendanceRepository;

    @Autowired
    public AttendanceService(AttendanceRepository attendanceRepository) {
        this.attendanceRepository = attendanceRepository;
    }

    public List<Attendance> getAllAttendance() {
        return attendanceRepository.findAll();
    }

    public Attendance getAttendenceById(int id) {
        Optional<Attendance> optionalAttendance = attendanceRepository.findById(id);
        return optionalAttendance.orElse(null);
    }

    public Attendance addAttendance(Attendance attendance) {
        return attendanceRepository.save(attendance);
    }

    public Attendance updateAttendence(int id, Attendance attendance) {
        if (attendanceRepository.existsById(id)){
            attendance.setId(id);
            return attendanceRepository.save(attendance);
        } else {
            return null;
        }
    }

    public void deleteAttendence(int id) {
        attendanceRepository.deleteById(id);
    }
}