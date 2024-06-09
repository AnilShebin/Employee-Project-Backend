package com.groot.anil.service;

import com.groot.anil.entity.Performance;
import com.groot.anil.repository.PerformanceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PerformanceService {

    private final PerformanceRepository performanceRepository;

    @Autowired
    public PerformanceService(PerformanceRepository performanceRepository) {
        this.performanceRepository = performanceRepository;
    }

    public List<Performance> getAllPerformances() {
        return performanceRepository.findAll();
    }

    public Performance getPerformanceById(int id) {
        Optional<Performance> optionalPerformance = performanceRepository.findById(id);
        return optionalPerformance.orElse(null);
    }

    public Performance addPerformance(Performance performance) {
        return performanceRepository.save(performance);
    }

    public Performance updatePerformance(int id, Performance performance) {
        if (performanceRepository.existsById(id)) {
            performance.setId(id);
            return performanceRepository.save(performance);
        } else {
            return null;
        }
    }

    public void deletePerformance(int id) {
        performanceRepository.deleteById(id);
    }
}