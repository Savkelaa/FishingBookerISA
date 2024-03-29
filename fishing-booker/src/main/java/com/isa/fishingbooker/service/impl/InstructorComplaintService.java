package com.isa.fishingbooker.service.impl;

import com.isa.fishingbooker.controller.UserController;
import com.isa.fishingbooker.exception.ResourceNotFoundException;
import com.isa.fishingbooker.model.InstructorComplaint;

import com.isa.fishingbooker.repository.InstructorComplaintRepository;
import com.isa.fishingbooker.service.EmailService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.OptimisticLockingFailureException;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import javax.transaction.Transactional;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class InstructorComplaintService {
    @Autowired
    private EmailService emailService;

    private Logger logger = LoggerFactory.getLogger(UserController.class);
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

@Transactional
    public ResponseEntity<InstructorComplaint> updateInstructorComplaint(Integer instructorComplaintId,
                                                               @RequestBody InstructorComplaint instructorComplaintDetails) throws ResourceNotFoundException {


        try{
            InstructorComplaint instructorComplaint = instructorComplaintRepository.findById(instructorComplaintId)
                    .orElseThrow(() -> new ResourceNotFoundException("InstructorComplaint not found for this id :: " + instructorComplaintId));

            instructorComplaint.setActive(instructorComplaintDetails.getActive());
            instructorComplaint.setDescription(instructorComplaintDetails.getDescription());
            instructorComplaint.setAnswer(instructorComplaintDetails.getAnswer());
            instructorComplaint.setInstructor(instructorComplaintDetails.getInstructor());
            instructorComplaint.setClient(instructorComplaintDetails.getClient());

            try {
                System.out.println("Thread id: " + Thread.currentThread().getId());
                emailService.sendNotificaitionAsyncAcceptComplaintClient(instructorComplaint.getClient(), instructorComplaint.getAnswer());
                emailService.sendNotificaitionAsyncAcceptComplaintInstructor(instructorComplaint.getInstructor(), instructorComplaint.getAnswer());
            } catch (Exception e) {
                logger.info("Greska prilikom slanja emaila: " + e.getMessage());
            }


            final InstructorComplaint updatedInstructorComplaint = instructorComplaintRepository.save(instructorComplaint);
            return ResponseEntity.ok(updatedInstructorComplaint);
        }catch(OptimisticLockingFailureException e)
        {
            return null;
        }

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
