package com.backend.repository;

import com.backend.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RegistrationRepository extends JpaRepository<User,Integer> {
    public User findByEmailId(String emilId);

    public User findByEmailIdAndPassword(String emailId, String password);
}
