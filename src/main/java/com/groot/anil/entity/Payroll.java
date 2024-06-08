package com.groot.anil.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.util.Date;

@Data
@Entity
@Table(name = "payroll")
public class Payroll {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "employee_id")
    private Employee employee;

    @Column(name = "salary")
    private double salary;

    @Column(name = "bonus")
    private double bonus;

    @Column(name = "pay_date")
    @Temporal(TemporalType.DATE)
    private Date payDate;
}
