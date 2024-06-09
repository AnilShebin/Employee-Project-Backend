package com.groot.anil.entity;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "holiday")
public class Holiday {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name="holiday_name")
    private String holidayName;

    @Column(name="holiday_date")
    private String holidayDate;
}