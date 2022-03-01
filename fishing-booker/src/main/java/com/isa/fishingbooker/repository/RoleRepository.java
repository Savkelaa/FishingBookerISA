package com.isa.fishingbooker.repository;

import java.util.List;

import com.isa.fishingbooker.model.Role;
import org.springframework.data.jpa.repository.JpaRepository;


public interface RoleRepository extends JpaRepository<Role, Long> {
	List<Role> findByName(String name);
}
