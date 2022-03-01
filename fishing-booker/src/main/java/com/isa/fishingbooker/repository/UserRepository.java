package com.isa.fishingbooker.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.isa.fishingbooker.model.User;

public interface UserRepository extends JpaRepository<User, Long> {
    User findByUsername(String username);
}

