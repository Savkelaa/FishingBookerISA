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
import com.isa.fishingbooker.model.CottageRoom;
import com.isa.fishingbooker.repository.CottageRoomRepository;

@Service
public class CottageRoomService {

	@Autowired
	private CottageRoomRepository CottageRoomRepository;
	
	public List<CottageRoom> getAllCottageRooms(){
		return this.CottageRoomRepository.findAll();
	}
		
	public ResponseEntity<CottageRoom> getCottageRoomById(int cottageRoomId)
		throws ResourceNotFoundException{
		CottageRoom cottageRoom = CottageRoomRepository.findById(cottageRoomId).orElseThrow(() -> new ResourceNotFoundException("CottageRoom not found for this id :: " + cottageRoomId));
	 return ResponseEntity.ok().body(cottageRoom);
	}
	
	@PostMapping("/cottageRooms")
	public CottageRoom createCottageRoom(CottageRoom cottageRoom) {
		return CottageRoomRepository.save(cottageRoom);
	}
	
	
	@PutMapping("/cottageRoom/{id}")
	public ResponseEntity<CottageRoom> updateCottageRoom(Integer cottageRoomId,
			 @RequestBody CottageRoom cottageRoomDetails) throws ResourceNotFoundException {
		CottageRoom cottageRoom = CottageRoomRepository.findById(cottageRoomId)
				.orElseThrow(() -> new ResourceNotFoundException("CottageRoom not found for this id :: " + cottageRoomId));
		
		cottageRoom.setNumber(cottageRoomDetails.getNumber());
		cottageRoom.setNum_beds(cottageRoomDetails.getNum_beds());
	
		final CottageRoom updatedCottageRoom = CottageRoomRepository.save(cottageRoom);
		return ResponseEntity.ok(updatedCottageRoom);
	}
	
	@DeleteMapping("/cottageRooms/{id}")
	public Map<String, Boolean> deleteCottageRoom(int cottageRoomId)
			throws ResourceNotFoundException {
		CottageRoom  cottageRoom = CottageRoomRepository.findById(cottageRoomId)
				.orElseThrow(() -> new ResourceNotFoundException("CottageRoom not found for this id :: " + cottageRoomId));

		CottageRoomRepository.delete(cottageRoom);
		Map<String, Boolean> response = new HashMap<>();
		response.put("deleted", Boolean.TRUE);
		return response;
	}
}
