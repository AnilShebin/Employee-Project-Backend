package com.groot.anil.service;

import com.groot.anil.entity.Payroll;
import com.groot.anil.repository.PayrollRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PayrollService {

    private final PayrollRepository payrollRepository;

    @Autowired
    public PayrollService(PayrollRepository payrollRepository) {
        this.payrollRepository = payrollRepository;
    }

    public List<Payroll> getAllPayrolls() {
        return payrollRepository.findAll();
    }

    public Payroll getPayrollById(int id) {
        Optional<Payroll> optionalPayroll = payrollRepository.findById(id);
        return optionalPayroll.orElse(null);
    }

    public Payroll addPayroll(Payroll payroll) {
        return payrollRepository.save(payroll);
    }

    public Payroll updatePayroll(int id, Payroll payroll) {
        if (payrollRepository.existsById(id)) {
            payroll.setId(id);
            return payrollRepository.save(payroll);
        } else {
            return null;
        }
    }

    public void deletePayroll(int id) {
        payrollRepository.deleteById(id);
    }
}