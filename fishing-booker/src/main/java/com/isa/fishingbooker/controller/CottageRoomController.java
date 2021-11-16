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
import org.springframework.web.bind.annotation.RestController;

import com.isa.fishingbooker.exception.ResourceNotFoundException;
import com.isa.fishingbooker.model.CottageRoom;
import com.isa.fishingbooker.service.CottageRoomService;

@RestController
@RequestMapping("/api/v1")
public class CottageRoomController {

	@Autowired
	private CottageRoomService cottageRoomService;

	@GetMapping("/cottageRooms")
	public List<CottageRoom> getAllCottageRooms() {
		return this.cottageRoomService.getAllCottageRooms();
	}

	@GetMapping("/cottageRooms/{id}")
	public ResponseEntity<CottageRoom> getCottageRoomById(@PathVariable(value = "id") int cottageRoomId)
			throws ResourceNotFoundException {
		return cottageRoomService.getCottageRoomById(cottageRoomId);
	}

	@PostMapping("/cottageRooms")
	public CottageRoom createCottageRoom(@RequestBody CottageRoom cottageRoom) {
		return cottageRoomService.createCottageRoom(cottageRoom);
	}

	@PutMapping("/cottageRooms/{id}")
	public ResponseEntity<CottageRoom> updateCottageRoom(@PathVariable(value = "id") int cottageRoomId,
			@RequestBody CottageRoom cottageRoomDetails) throws ResourceNotFoundException {
		return cottageRoomService.updateCottageRoom(cottageRoomId, cottageRoomDetails);
	}

	@DeleteMapping("/cottageRooms/{id}")
	public Map<String, Boolean> deleteCottageRoom(@PathVariable(value = "id") int cottageRoomId)
			throws ResourceNotFoundException {
		return cottageRoomService.deleteCottageRoom(cottageRoomId);
	}
}
