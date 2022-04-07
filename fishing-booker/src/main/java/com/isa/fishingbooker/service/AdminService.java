package com.isa.fishingbooker.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.isa.fishingbooker.controller.UserController;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.isa.fishingbooker.exception.ResourceNotFoundException;
import com.isa.fishingbooker.model.Admin;
import com.isa.fishingbooker.model.Admin;
import com.isa.fishingbooker.repository.AdminRepository;

@Service
public class AdminService {

	private Logger logger = LoggerFactory.getLogger(UserController.class);

	@Autowired
	private EmailService emailService;

	@Autowired
	private AdminRepository AdminRepository;
	
	@Autowired
	private PasswordEncoder passwordEncoder;
	
	
	public List<Admin> getAllAdmins(){
		return this.AdminRepository.findAll();
	}
	

	
	public ResponseEntity<Admin> getAdminById(int adminId)
		throws ResourceNotFoundException{
		Admin admin = AdminRepository.findById(adminId).orElseThrow(() -> new ResourceNotFoundException("Admin not found for this id :: " + adminId));
	 return ResponseEntity.ok().body(admin);
	}
	
	
	public Admin createAdmin(Admin admin) throws Exception{
		try {
			System.out.println("Thread id: " + Thread.currentThread().getId());
			emailService.sendNotificaitionAsync(admin);
		}catch( Exception e ){
			logger.info("Greska prilikom slanja emaila: " + e.getMessage());
		}

		admin.setActivated("false");
		admin.setDeleted("false");
		admin.setPassword(passwordEncoder.encode(admin.getPassword()));
		return AdminRepository.save(admin);
	}

	public List<Admin> getAllAdminDeleteRequests() {
		return AdminRepository.getAllAdminDeleteRequests();
	}
	
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

	public ResponseEntity<Admin> adminSendDeleteRequest(Integer adminId,
											 @RequestBody Admin adminDetails) throws ResourceNotFoundException {
		Admin admin = AdminRepository.findById(adminId)
				.orElseThrow(() -> new ResourceNotFoundException("Admin not found for this id :: " + adminId));


		admin.setDeleteReason(adminDetails.getDeleteReason());
		admin.setDeleteRequest("true");

		final Admin updatedAdmin = AdminRepository.save(admin);
		return ResponseEntity.ok(updatedAdmin);
	}
	
	
	
	public Map<String, Boolean> deleteAdmin(int adminId)
			throws ResourceNotFoundException {
		Admin  admin = AdminRepository.findById(adminId)
				.orElseThrow(() -> new ResourceNotFoundException("Admin not found for this id :: " + adminId));

		AdminRepository.delete(admin);
		Map<String, Boolean> response = new HashMap<>();
		response.put("deleted", Boolean.TRUE);
		return response;
	}
	public Admin getAdminByEmailAndPassword(String email, String password) {
		return AdminRepository.getAdminByEmailAndPassword(email, password);
	}
}
