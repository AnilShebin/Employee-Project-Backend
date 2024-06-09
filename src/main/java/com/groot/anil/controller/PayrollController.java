package com.groot.anil.controller;

import com.groot.anil.entity.Payroll;
import com.groot.anil.service.PayrollService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/payroll")
public class PayrollController {

    private PayrollService payrollService;

    @Autowired
    public PayrollController(PayrollService payrollService) {
        this.payrollService = payrollService;
    }

    @GetMapping
    public List<Payroll> getAllPayrolls() {
        return payrollService.getAllPayrolls();
    }

    @PostMapping
    public Payroll addPayroll(@RequestBody Payroll payroll) {
        return payrollService.addPayroll(payroll);
    }

    @GetMapping("/{id}")
    public Payroll getPayrollById(@PathVariable int id) {
        return payrollService.getPayrollById(id);
    }

    @PutMapping("/{id}")
    public Payroll updatePayroll(@PathVariable int id, @RequestBody Payroll payroll) {
        return payrollService.updatePayroll(id, payroll);
    }

    @DeleteMapping("/{id}")
    public void deletePayroll(@PathVariable int id) {
        payrollService.deletePayroll(id);
    }
}
