package com.isa.fishingbooker.service;

import com.isa.fishingbooker.exception.ResourceNotFoundException;

import com.isa.fishingbooker.model.InstructorReport;

import com.isa.fishingbooker.repository.InstructorReportRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class InstructorReportService {
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
