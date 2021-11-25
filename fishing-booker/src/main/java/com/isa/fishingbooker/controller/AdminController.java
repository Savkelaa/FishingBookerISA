package com.isa.fishingbooker.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.isa.fishingbooker.exception.ResourceNotFoundException;
import com.isa.fishingbooker.model.Admin;
import com.isa.fishingbooker.model.Client;
import com.isa.fishingbooker.service.AdminService;

@RestController
@RequestMapping("/api/v1")
public class AdminController {

	@Autowired
	private AdminService adminService;

	@GetMapping("/admins")
	public List<Admin> getAllAdmins() {
		return this.adminService.getAllAdmins();
	}

	@GetMapping("/admins/{id}")
	public ResponseEntity<Admin> getAdminById(@PathVariable(value = "id") int adminId)
			throws ResourceNotFoundException {
		return adminService.getAdminById(adminId);
	}

	@PostMapping("/admins")
	public Admin createAdmin(@RequestBody Admin admin) {
		return adminService.createAdmin(admin);
	}

	@PutMapping("/admins/{id}")
	public ResponseEntity<Admin> updateAdmin(@PathVariable(value = "id") int adminId,
			@RequestBody Admin adminDetails) throws ResourceNotFoundException {
		return adminService.updateAdmin(adminId, adminDetails);
	}

	@DeleteMapping("/admins/{id}")
	public Map<String, Boolean> deleteAdmin(@PathVariable(value = "id") int adminId)
			throws ResourceNotFoundException {
		return adminService.deleteAdmin(adminId);
	}
	@GetMapping("/adminByEmailAndPassword")
	public Admin getInstructorByEmailAndPassword(@RequestParam (value="email")  String email, @RequestParam (value="password") String password) {
		return adminService.getAdminByEmailAndPassword(email, password);
	}
}
