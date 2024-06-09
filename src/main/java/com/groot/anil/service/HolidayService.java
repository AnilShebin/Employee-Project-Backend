package com.groot.anil.service;

import com.groot.anil.entity.Holiday;
import com.groot.anil.repository.HolidayRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class HolidayService {

    private final HolidayRepository holidayRepository;

    @Autowired
    public HolidayService(HolidayRepository holidayRepository) {
        this.holidayRepository = holidayRepository;
    }

    public List<Holiday> getHolidays() {
        return holidayRepository.findAll();
    }

    public Holiday getHolidayById(int id) {
        Optional<Holiday> optionalHoliday = holidayRepository.findById(id);
        return optionalHoliday.orElse(null);
    }

    public Holiday addHoliday(Holiday holiday) {
        return holidayRepository.save(holiday);
    }

    public Holiday updateHoliday(int id, Holiday holiday) {
        if (holidayRepository.existsById(id)) {
            holiday.setId(id);
            return holidayRepository.save(holiday);
        } else {
            return null;
        }
    }

    public void deleteHoliday(int id) {
        holidayRepository.deleteById(id);
    }
}