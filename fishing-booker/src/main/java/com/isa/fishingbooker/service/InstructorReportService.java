package com.isa.fishingbooker.service;

import com.isa.fishingbooker.controller.UserController;
import com.isa.fishingbooker.exception.ResourceNotFoundException;

import com.isa.fishingbooker.model.InstructorReport;

import com.isa.fishingbooker.repository.InstructorReportRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class InstructorReportService {
    private Logger logger = LoggerFactory.getLogger(UserController.class);

    @Autowired
    private EmailService emailService;

    @Autowired
    private InstructorReportRepository instructorReportRepository;

    public List<InstructorReport> getAllInstructorReports(){
        return this.instructorReportRepository.findAll();
    }


    public List<InstructorReport> getAllBadInstructorReports(){
        return this.instructorReportRepository.getAllBadInstructorReports();
    }

    public ResponseEntity<InstructorReport> getInstructorReportById(int instructorReportId)
            throws ResourceNotFoundException {
        InstructorReport instructorReport = instructorReportRepository.findById(instructorReportId).orElseThrow(() -> new ResourceNotFoundException("InstructorReport not found for this id :: " + instructorReportId));
        return ResponseEntity.ok().body(instructorReport);
    }


    public InstructorReport createInstructorReport(InstructorReport instructorReport) {
        return instructorReportRepository.save(instructorReport);
    }



    public ResponseEntity<InstructorReport> updateInstructorReport(Integer instructorReportId,
                                                                       @RequestBody InstructorReport instructorReportDetails) throws ResourceNotFoundException {
        InstructorReport instructorReport = instructorReportRepository.findById(instructorReportId)
                .orElseThrow(() -> new ResourceNotFoundException("InstructorReport not found for this id :: " + instructorReportId));

        instructorReport.setDescription(instructorReportDetails.getDescription());
        instructorReport.setBad(instructorReportDetails.getBad());
        instructorReport.setDescription(instructorReportDetails.getDescription());
        instructorReport.setClient(instructorReportDetails.getClient());
        instructorReport.setInstructor(instructorReportDetails.getInstructor());


        if(instructorReportDetails.getBad().toString().equals("false")) {
            try {
                System.out.println("Thread id: " + Thread.currentThread().getId());
                emailService.sendNotificaitionPenaltyToClient(instructorReportDetails.getClient());
                emailService.sendNotificaitionPenaltyToInstructor( instructorReportDetails.getInstructor());

            } catch (Exception e) {
                logger.info("Greska prilikom slanja emaila: " + e.getMessage());
            }
        }

        final InstructorReport updatedInstructorReport = instructorReportRepository.save(instructorReport);
        return ResponseEntity.ok(updatedInstructorReport);
    }


    public Map<String, Boolean> deleteInstructorReport(int instructorReportId)
            throws ResourceNotFoundException {
        InstructorReport  instructorReport = instructorReportRepository.findById(instructorReportId)
                .orElseThrow(() -> new ResourceNotFoundException("InstructorReport not found for this id :: " + instructorReportId));

        instructorReportRepository.delete(instructorReport);
        Map<String, Boolean> response = new HashMap<>();
        response.put("deleted", Boolean.TRUE);
        return response;
    }

}
