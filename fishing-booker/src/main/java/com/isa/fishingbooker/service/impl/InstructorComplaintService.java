package com.isa.fishingbooker.service.impl;

import com.isa.fishingbooker.exception.ResourceNotFoundException;
import com.isa.fishingbooker.model.InstructorComplaint;

import com.isa.fishingbooker.repository.InstructorComplaintRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class InstructorComplaintService {

    @Autowired
    private InstructorComplaintRepository instructorComplaintRepository;

    public List<InstructorComplaint> getAllInstructorComplaints(){
        return this.instructorComplaintRepository.findAll();
    }

    public List<InstructorComplaint> getAllInstructorComplaintRequests(){
        return this.instructorComplaintRepository.getAllInstructorComplaintRequests();
    }

    public ResponseEntity<InstructorComplaint> getInstructorComplaintById(int instructorComplaintId)
            throws ResourceNotFoundException {
        InstructorComplaint instructorComplaint = instructorComplaintRepository.findById(instructorComplaintId).orElseThrow(() -> new ResourceNotFoundException("InstructorComplaint not found for this id :: " + instructorComplaintId));
        return ResponseEntity.ok().body(instructorComplaint);
    }


    public InstructorComplaint createInstructorComplaint(InstructorComplaint instructorComplaint) {
        return instructorComplaintRepository.save(instructorComplaint);
    }


    public ResponseEntity<InstructorComplaint> updateInstructorComplaint(Integer instructorComplaintId,
                                                               @RequestBody InstructorComplaint instructorComplaintDetails) throws ResourceNotFoundException {
        InstructorComplaint instructorComplaint = instructorComplaintRepository.findById(instructorComplaintId)
                .orElseThrow(() -> new ResourceNotFoundException("InstructorComplaint not found for this id :: " + instructorComplaintId));

        instructorComplaint.setActive(instructorComplaintDetails.getActive());
        instructorComplaint.setDescription(instructorComplaintDetails.getDescription());



      //      try {
       //         System.out.println("Thread id: " + Thread.currentThread().getId());
       //         emailService.sendNotificaitionAsyncAcceptComplaint(instructorComplaint.getClient());
      //      } catch (Exception e) {
       //         logger.info("Greska prilikom slanja emaila: " + e.getMessage());
       //     }


        final InstructorComplaint updatedInstructorComplaint = instructorComplaintRepository.save(instructorComplaint);
        return ResponseEntity.ok(updatedInstructorComplaint);
    }

    public Map<String, Boolean> deleteInstructorComplaint(int instructorComplaintId)
            throws ResourceNotFoundException {
        InstructorComplaint instructorComplaint = instructorComplaintRepository.findById(instructorComplaintId)
                .orElseThrow(() -> new ResourceNotFoundException("InstructorComplaint not found for this id :: " + instructorComplaintId));

        instructorComplaintRepository.delete(instructorComplaint);
        Map<String, Boolean> response = new HashMap<>();
        response.put("deleted", Boolean.TRUE);
        return response;
    }


}
