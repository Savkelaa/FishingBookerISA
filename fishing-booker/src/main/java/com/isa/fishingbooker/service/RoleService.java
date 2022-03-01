package com.isa.fishingbooker.service;

import java.util.List;

import com.isa.fishingbooker.model.Role;

public interface RoleService {
	Role findById(Long id);
	List<Role> findByName(String name);
}
