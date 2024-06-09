package com.groot.anil.controller;

import com.groot.anil.entity.Performance;
import com.groot.anil.service.PerformanceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/performance")
public class PerformanceController {

    private PerformanceService performanceService;

    @Autowired
    public PerformanceController (PerformanceService performanceService) {
        this.performanceService = performanceService;
    }

    @GetMapping
    public List<Performance> getAllPerformance() {
        return performanceService.getAllPerformances();
    }

    @PostMapping
    public Performance addPerformance(@RequestBody Performance performance) {
        return performanceService.addPerformance(performance);
    }

    @GetMapping("/{id}")
    public Performance getPerformanceById(@PathVariable int id) {
        return performanceService.getPerformanceById(id);
    }

    @PutMapping("/{id}")
    public Performance updatePerformance(@PathVariable int id, @RequestBody Performance performance) {
        return performanceService.updatePerformance(id, performance);
    }

    @DeleteMapping("/{id}")
    public void deletePerformance(@PathVariable int id) {
        performanceService.deletePerformance(id);
    }
}