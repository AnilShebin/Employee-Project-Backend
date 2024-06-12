package com.groot.anil.repository;

import com.groot.anil.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

public interface UserRepository extends JpaRepository<User, Integer> {
    public User findByEmail(String email);

    public User findByVerificationCode(String code);

    @Query("update User u set u.failedAttempt=?1 where email=?2")
    @Modifying
    public void updateFailedtempt(int attempt, String email);

}
