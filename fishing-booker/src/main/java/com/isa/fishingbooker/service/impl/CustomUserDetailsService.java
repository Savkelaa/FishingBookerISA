package com.isa.fishingbooker.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.isa.fishingbooker.model.Admin;
import com.isa.fishingbooker.model.BoatOwner;
import com.isa.fishingbooker.model.Client;
import com.isa.fishingbooker.model.CottageOwner;
import com.isa.fishingbooker.model.Instructor;
import com.isa.fishingbooker.model.User;
import com.isa.fishingbooker.repository.AdminRepository;
import com.isa.fishingbooker.repository.BoatOwnerRepository;
import com.isa.fishingbooker.repository.ClientRepository;
import com.isa.fishingbooker.repository.CottageOwnerRepository;
import com.isa.fishingbooker.repository.InstructorRepository;
import com.isa.fishingbooker.repository.UserRepository;

// Ovaj servis je namerno izdvojen kao poseban u ovom primeru.
// U opstem slucaju UserServiceImpl klasa bi mogla da implementira UserDetailService interfejs.
@Service
public class CustomUserDetailsService implements UserDetailsService {

	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private ClientRepository clientRepository;
	
	@Autowired 
	private BoatOwnerRepository boatOwnerRepository;
	
	@Autowired
	private AdminRepository adminRepository;
	
	@Autowired
	private CottageOwnerRepository cottageOwnerRepository;
	
	@Autowired
	private InstructorRepository instructorRepository;
	



	// Funkcija koja na osnovu username-a iz baze vraca objekat User-a
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
	//	User user = userRepository.findByEmail(username);
		Client client= clientRepository.findByEmail(username);
		Admin admin= adminRepository.getAdminByEmail(username);
		BoatOwner boatOwner= boatOwnerRepository.getBoatOwnerByEmail(username);
		CottageOwner cottageOwner= cottageOwnerRepository.getCottageOwnerByEmail(username);
		Instructor instructor=instructorRepository.getInstructorByEmail(username);
		if (client != null) {
			return client;
		}else if(admin != null) {
			return admin;
		}
		else if(boatOwner != null) {
			return boatOwner;
		}
		else if(cottageOwner != null) {
			return cottageOwner;
		}
		else if(instructor != null) {
			return instructor;
		}
		else {
			throw new UsernameNotFoundException(String.format("No user found with username '%s'.", username));
		}
	}

}
