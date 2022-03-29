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
import com.isa.fishingbooker.model.Admin;
import com.isa.fishingbooker.model.BoatOwner;
import com.isa.fishingbooker.model.Client;
import com.isa.fishingbooker.model.CottageOwner;
import com.isa.fishingbooker.model.Instructor;
import com.isa.fishingbooker.repository.AdminRepository;
import com.isa.fishingbooker.repository.BoatOwnerRepository;
import com.isa.fishingbooker.repository.ClientRepository;
import com.isa.fishingbooker.repository.CottageOwnerRepository;
import com.isa.fishingbooker.repository.InstructorRepository;
import com.isa.fishingbooker.repository.UserRepository;
import com.isa.fishingbooker.service.AdminService;
import com.isa.fishingbooker.service.BoatOwnerService;
import com.isa.fishingbooker.service.ClientService;
import com.isa.fishingbooker.service.CottageOwnerService;
import com.isa.fishingbooker.service.InstructorService;
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
	
	@Autowired
	private ClientService clientService;
	
	@Autowired
	private AdminService adminService;
	
	@Autowired
	private InstructorService instructorService;
	
	@Autowired
	private CottageOwnerService cottageOwnerService;
	
	@Autowired
	private BoatOwnerService boatOwnerService;
	
	
	
	
	// Prvi endpoint koji pogadja korisnik kada se loguje.
	// Tada zna samo svoje korisnicko ime i lozinku i to prosledjuje na backend.
	//ResponseEntity<UserTokenState>
	@PostMapping("/loginClient")
	public Client createAuthenticationToken(
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
			return user;
		} 
		/*	
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
		}*/
		else {
			return null;
		}
	}
	
	@PostMapping("/loginCottageOwner")
	public CottageOwner createCottageOwnerAuthenticationToken(
			@RequestBody JwtAuthenticationRequest authenticationRequest, HttpServletResponse response) {

		Authentication authentication = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(
				authenticationRequest.getEmail(), authenticationRequest.getPassword()));

		SecurityContextHolder.getContext().setAuthentication(authentication);
		
		if (cottageOwnerRepository.getCottageOwnerByEmail(authenticationRequest.getEmail()) != null) {
			CottageOwner user = (CottageOwner) authentication.getPrincipal();
			String jwt = tokenUtils.generateToken(user.getUsername());
			int expiresIn = tokenUtils.getExpiredIn();
			return user;
		}else {
			return null;
		}
	}
	
	@PostMapping("/loginInstructor")
	public Instructor createInstructorAuthenticationToken(
			@RequestBody JwtAuthenticationRequest authenticationRequest, HttpServletResponse response) {

		Authentication authentication = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(
				authenticationRequest.getEmail(), authenticationRequest.getPassword()));

		SecurityContextHolder.getContext().setAuthentication(authentication);

		if (instructorRepository.getInstructorByEmail(authenticationRequest.getEmail()) != null) {
			Instructor user = (Instructor) authentication.getPrincipal();
			String jwt = tokenUtils.generateToken(user.getUsername());
			int expiresIn = tokenUtils.getExpiredIn();
			return user;
		}else {
			return null;
		}
	}
	
	@PostMapping("/loginAdmin")
    public Admin createAdminAuthenticationToken(
            @RequestBody JwtAuthenticationRequest authenticationRequest, HttpServletResponse response) {


        Authentication authentication = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(
                authenticationRequest.getEmail(), authenticationRequest.getPassword()));

        SecurityContextHolder.getContext().setAuthentication(authentication);
        if (adminRepository.getAdminByEmail(authenticationRequest.getEmail()) != null)
        {
            Admin user = (Admin) authentication.getPrincipal();
            String jwt = tokenUtils.generateToken(user.getUsername());
            int expiresIn = tokenUtils.getExpiredIn();
            return user;
        }
        else {
            return null;
        }
    }
	
	@PostMapping("/loginBoatOwner")
    public BoatOwner createBoatOwnerAuthenticationToken(
            @RequestBody JwtAuthenticationRequest authenticationRequest, HttpServletResponse response) {


        Authentication authentication = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(
                authenticationRequest.getEmail(), authenticationRequest.getPassword()));

        SecurityContextHolder.getContext().setAuthentication(authentication);
        if(boatOwnerRepository.getBoatOwnerByEmail(authenticationRequest.getEmail()) != null) {
            BoatOwner user = (BoatOwner) authentication.getPrincipal();
            String jwt = tokenUtils.generateToken(user.getUsername());
            int expiresIn = tokenUtils.getExpiredIn();
            return user;
        }
        else {
            return null;
        }
    }
	
	// Endpoint za registraciju novog korisnika
	@PostMapping("/signUpClient")
	public ResponseEntity<Client> addClient(@RequestBody Client client, UriComponentsBuilder ucBuilder) throws Exception {

		Client existUser = this.clientRepository.findByEmail(client.getEmail());

		if (existUser != null) {
			throw new Exception("Email already exists");
		}

		Client user = this.clientService.createClient(client);
		return new ResponseEntity<>(user, HttpStatus.CREATED);
	}
	
	@PostMapping("/signUpAdmin")
	public ResponseEntity<Admin> addAdmin(@RequestBody Admin admin, UriComponentsBuilder ucBuilder) throws Exception {

		Admin existUser = this.adminRepository.getAdminByEmail(admin.getEmail());

		if (existUser != null) {
			throw new Exception("Email already exists");
		}

		Admin user = this.adminService.createAdmin(admin);
		return new ResponseEntity<>(user, HttpStatus.CREATED);
	}
	
	@PostMapping("/signUpInstructor")
	public ResponseEntity<Instructor> addInstructor(@RequestBody Instructor instructor, UriComponentsBuilder ucBuilder) throws Exception {

		Instructor existUser = this.instructorRepository.getInstructorByEmail(instructor.getEmail());

		if (existUser != null) {
			throw new Exception("Email already exists");
		}

		Instructor user = this.instructorService.createInstructor(instructor);
		return new ResponseEntity<>(user, HttpStatus.CREATED);
	}
	
	@PostMapping("/signUpBoatOwner")
	public ResponseEntity<BoatOwner> addBoatOwner(@RequestBody BoatOwner boatOwner, UriComponentsBuilder ucBuilder) throws Exception {

		BoatOwner existUser = this.boatOwnerRepository.getBoatOwnerByEmail(boatOwner.getEmail());

		if (existUser != null) {
			throw new Exception("Email already exists");
		}

		BoatOwner user = this.boatOwnerService.createBoatOwner(boatOwner);
		return new ResponseEntity<>(user, HttpStatus.CREATED);
	}
	
	@PostMapping("/signUpCottageOwner")
	public ResponseEntity<CottageOwner> addCottageOwner(@RequestBody CottageOwner cottageOwner, UriComponentsBuilder ucBuilder) throws Exception {

		CottageOwner existUser = this.cottageOwnerRepository.getCottageOwnerByEmail(cottageOwner.getEmail());

		if (existUser != null) {
			throw new Exception("Email already exists");
		}

		CottageOwner user = this.cottageOwnerService.createCottageOwner(cottageOwner);
		return new ResponseEntity<>(user, HttpStatus.CREATED);
	}
	
}