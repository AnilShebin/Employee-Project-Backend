package com.groot.anil.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.util.Date;

@Data
@Entity
@Table(name = "performance")
public class Performance {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "employee_id")
    private Employee employee;

    @Column(name = "evaluation_date")
    @Temporal(TemporalType.DATE)
    private Date evaluationDate;

    @Column(name = "score")
    private double score;

    @Column(name = "comments")
    private String comments;
}