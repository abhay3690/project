package com.example.demo.repository;

import com.example.demo.enums.UserRole;
import com.example.demo.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepo extends JpaRepository<User, Integer> {

    Optional<User> findFirstByEmail(String email);

    User findByUserRole(UserRole userRole);
}
