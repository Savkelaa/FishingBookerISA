package com.isa.fishingbooker.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.isa.fishingbooker.exception.ResourceNotFoundException;
import com.isa.fishingbooker.model.Admin;
import com.isa.fishingbooker.repository.AdminRepository;

@Service
public class AdminService {

	@Autowired
	private AdminRepository AdminRepository;
	
	
	public List<Admin> getAllAdmins(){
		return this.AdminRepository.findAll();
	}
	

	
	public ResponseEntity<Admin> getAdminById(int adminId)
		throws ResourceNotFoundException{
		Admin admin = AdminRepository.findById(adminId).orElseThrow(() -> new ResourceNotFoundException("Admin not found for this id :: " + adminId));
	 return ResponseEntity.ok().body(admin);
	}
	
	@PostMapping("/admins")
	public Admin createAdmin(Admin admin) {
		return AdminRepository.save(admin);
	}
	
	
	@PutMapping("/admin/{id}")
	public ResponseEntity<Admin> updateAdmin(Integer adminId,
			 @RequestBody Admin adminDetails) throws ResourceNotFoundException {
		Admin admin = AdminRepository.findById(adminId)
				.orElseThrow(() -> new ResourceNotFoundException("Admin not found for this id :: " + adminId));
		
		admin.setAddress(adminDetails.getAddress());
		admin.setCity(adminDetails.getCity());
		admin.setCountry(adminDetails.getCountry());
		admin.setEmail(adminDetails.getEmail());
		admin.setExplanation(adminDetails.getExplanation());
		admin.setName(adminDetails.getName());
		admin.setNumber(adminDetails.getNumber());
		admin.setPassword(adminDetails.getPassword());
		admin.setMoney(adminDetails.getMoney());
		admin.setSurname(adminDetails.getSurname());
		
		final Admin updatedAdmin = AdminRepository.save(admin);
		return ResponseEntity.ok(updatedAdmin);
	}
	
	@DeleteMapping("/admins/{id}")
	public Map<String, Boolean> deleteAdmin(int adminId)
			throws ResourceNotFoundException {
		Admin  admin = AdminRepository.findById(adminId)
				.orElseThrow(() -> new ResourceNotFoundException("Admin not found for this id :: " + adminId));

		AdminRepository.delete(admin);
		Map<String, Boolean> response = new HashMap<>();
		response.put("deleted", Boolean.TRUE);
		return response;
	}
}
