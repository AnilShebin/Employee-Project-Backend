package com.groot.anil.entity;

import java.util.Date;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

@Entity
@Data
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String fullname;
    private String email;
    private String mobileno;
    private String password;
    private boolean enable;
    private String verificationCode;
    private boolean isAccountNonLocked;
    private int failedAttempt;
    private Date lockTime;
    private String role;
}
