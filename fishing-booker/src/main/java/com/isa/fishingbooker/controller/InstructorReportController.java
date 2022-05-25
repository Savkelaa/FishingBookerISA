package com.isa.fishingbooker.controller;

import com.isa.fishingbooker.exception.ResourceNotFoundException;
import com.isa.fishingbooker.model.InstructorReport;
import com.isa.fishingbooker.service.InstructorReportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@CrossOrigin
@RestController
@RequestMapping("/api/v1")
public class InstructorReportController {
    @Autowired
    private InstructorReportService instructorReportService;

    @GetMapping("/instructorReports")
    public List<InstructorReport> getAllInstructorReports() {
        return this.instructorReportService.getAllInstructorReports();
    }

    @GetMapping("/badInstructorReports")
    public List<InstructorReport> getAllBadInstructorReports() {
        return this.instructorReportService.getAllBadInstructorReports();
    }

    @GetMapping("/instructorReports/{id}")
    public ResponseEntity<InstructorReport> getInstrucotrReportById(@PathVariable(value = "id") int instructorReportId)
            throws ResourceNotFoundException {
        return instructorReportService.getInstructorReportById(instructorReportId);
    }

    @PostMapping("/instructorReports")
    public InstructorReport createInstructorReport(@RequestBody InstructorReport instructorReport) {
        return instructorReportService.createInstructorReport(instructorReport);
    }

    @PutMapping("/instructorReports/{id}")
    public ResponseEntity<InstructorReport> updateInstructorReport(@PathVariable(value = "id") int instructorReportId,
                                                                   @RequestBody InstructorReport instructorReportDetails) throws ResourceNotFoundException {
        return instructorReportService.updateInstructorReport(instructorReportId, instructorReportDetails);
    }

    @DeleteMapping("/instructorReports/{id}")
    public Map<String, Boolean> deleteInstructorReport(@PathVariable(value = "id") int instructorReportId)
            throws ResourceNotFoundException {
        return instructorReportService.deleteInstructorReport(instructorReportId);
    }
}
