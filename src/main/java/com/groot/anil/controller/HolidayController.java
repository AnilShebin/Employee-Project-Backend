package com.groot.anil.controller;

import com.groot.anil.entity.Employee;
import com.groot.anil.entity.Holiday;
import com.groot.anil.service.HolidayService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/holiday")
public class HolidayController {

    private final HolidayService holidayService;

    @Autowired
    public HolidayController(HolidayService holidayService) {
        this.holidayService = holidayService;
    }

    @GetMapping
    public List<Holiday> getHolidays() {
        return holidayService.getHolidays();
    }

    @PostMapping
    public Holiday addHoliday(@RequestBody Holiday holiday) {
        return holidayService.addHoliday(holiday);
    }

    @GetMapping("/{id}")
    public Holiday getHolidayById(@PathVariable int id) {
        return holidayService.getHolidayById(id);
    }

    @PutMapping("/{id}")
    public Holiday updateHoliday(@PathVariable int id, @RequestBody Holiday holiday) {
        return holidayService.updateHoliday(id, holiday);
    }

    @DeleteMapping("/{id}")
    public void deleteHoliday(@PathVariable int id) {
        holidayService.deleteHoliday(id);
    }
}
