package com.isa.fishingbooker.service;

import java.util.List;

import com.isa.fishingbooker.dto.UserRequest;
import com.isa.fishingbooker.model.User;

public interface UserService {
    User findById(Long id);
    User findByUsername(String username);
    List<User> findAll ();
	User save(UserRequest userRequest);
}
