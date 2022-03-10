package com.isa.fishingbooker.controller;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import com.isa.fishingbooker.dto.JwtAuthenticationRequest;
import com.isa.fishingbooker.dto.UserRequest;
import com.isa.fishingbooker.dto.UserTokenState;
import com.isa.fishingbooker.exception.ResourceConflictException;
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
import com.isa.fishingbooker.service.UserService;
import com.isa.fishingbooker.util.TokenUtils;

//Kontroler zaduzen za autentifikaciju korisnika
@RestController
@RequestMapping(value = "/auth", produces = MediaType.APPLICATION_JSON_VALUE)
public class AuthenticationController {

	@Autowired
	private TokenUtils tokenUtils;

	@Autowired
	private AuthenticationManager authenticationManager;

	@Autowired
	private UserService userService;
	
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
	
	// Prvi endpoint koji pogadja korisnik kada se loguje.
	// Tada zna samo svoje korisnicko ime i lozinku i to prosledjuje na backend.
	//ResponseEntity<UserTokenState>
	@PostMapping("/login")
	public String createAuthenticationToken(
			@RequestBody JwtAuthenticationRequest authenticationRequest, HttpServletResponse response) {

		// Ukoliko kredencijali nisu ispravni, logovanje nece biti uspesno, desice se
		// AuthenticationException
		Authentication authentication = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(
				authenticationRequest.getEmail(), authenticationRequest.getPassword()));

		// Ukoliko je autentifikacija uspesna, ubaci korisnika u trenutni security
		// kontekst
		SecurityContextHolder.getContext().setAuthentication(authentication);

		// Kreiraj token za tog korisnika
	/*	User user = (User) authentication.getPrincipal();
		String jwt = tokenUtils.generateToken(user.getUsername());
		int expiresIn = tokenUtils.getExpiredIn();

		// Vrati token kao odgovor na uspesnu autentifikaciju
		return ResponseEntity.ok(new UserTokenState(jwt, expiresIn)); */
		
		if (clientRepository.findByEmail(authenticationRequest.getEmail()) != null) {
			Client user = (Client) authentication.getPrincipal();
			String jwt = tokenUtils.generateToken(user.getUsername());
			int expiresIn = tokenUtils.getExpiredIn();
			return user.getName();
			//return ResponseEntity.ok(new UserTokenState(jwt, expiresIn));
		} else if (adminRepository.getAdminByEmail(authenticationRequest.getEmail()) != null)
		{
			Admin user = (Admin) authentication.getPrincipal();
			String jwt = tokenUtils.generateToken(user.getUsername());
			int expiresIn = tokenUtils.getExpiredIn();
			return user.getName();
			//return ResponseEntity.ok(new UserTokenState(jwt, expiresIn));
		}else if(boatOwnerRepository.getBoatOwnerByEmail(authenticationRequest.getEmail()) != null) {
			BoatOwner user = (BoatOwner) authentication.getPrincipal();
			String jwt = tokenUtils.generateToken(user.getUsername());
			int expiresIn = tokenUtils.getExpiredIn();
			return user.getName();
		}else if(cottageOwnerRepository.getCottageOwnerByEmail(authenticationRequest.getEmail()) != null) {
			CottageOwner user = (CottageOwner) authentication.getPrincipal();
			String jwt = tokenUtils.generateToken(user.getUsername());
			int expiresIn = tokenUtils.getExpiredIn();
			return user.getName();
		}else if(instructorRepository.getInstructorByEmail(authenticationRequest.getEmail()) != null) {
			Instructor user = (Instructor) authentication.getPrincipal();
			String jwt = tokenUtils.generateToken(user.getUsername());
			int expiresIn = tokenUtils.getExpiredIn();
			return user.getName();
		}
		else {
			return "greskica";
		}
	}

	// Endpoint za registraciju novog korisnika
	@PostMapping("/signup")
	public ResponseEntity<User> addUser(@RequestBody UserRequest userRequest, UriComponentsBuilder ucBuilder) {

		User existUser = this.userService.findByUsername(userRequest.getUsername());

		if (existUser != null) {
			throw new ResourceConflictException(userRequest.getId(), "Username already exists");
		}

		User user = this.userService.save(userRequest);

		return new ResponseEntity<>(user, HttpStatus.CREATED);
	}
}