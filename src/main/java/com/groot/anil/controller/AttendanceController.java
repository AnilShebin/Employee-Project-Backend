package com.groot.anil.controller;

import com.groot.anil.entity.Attendance;
import com.groot.anil.service.AttendanceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/attendance")
public class AttendanceController {

    private final AttendanceService attendanceService;

    @Autowired
    public AttendanceController(AttendanceService attendanceService) {
        this.attendanceService = attendanceService;
    }

    @GetMapping
    public List<Attendance> getAllAttendance(){
        return attendanceService.getAllAttendance();
    }

    @PostMapping
    public Attendance addAttendance(@RequestBody Attendance attendance){
        return attendanceService.addAttendance(attendance);
    }

    @GetMapping("/{id}")
    public Attendance getAttendenceById(@PathVariable int id){
        return attendanceService.getAttendenceById(id);
    }

    @PutMapping("/{id}")
    public Attendance updateAttendance(@PathVariable int id, @RequestBody Attendance attendance){
        return attendanceService.updateAttendence(id, attendance);
    }

    @DeleteMapping("/{id}")
    public void deleteAttendance(@PathVariable int id){
        attendanceService.deleteAttendence(id);
    }
}