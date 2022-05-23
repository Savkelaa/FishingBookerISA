package com.isa.fishingbooker.controller;

import com.isa.fishingbooker.exception.ResourceNotFoundException;
import com.isa.fishingbooker.model.InstructorComplaint;
import com.isa.fishingbooker.service.impl.InstructorComplaintService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@CrossOrigin
@RestController
@RequestMapping("/api/v1")
public class InstructorComplaintController {

    @Autowired
    private InstructorComplaintService instructorComplaintService;

    @GetMapping("/instructorComplaints")
    public List<InstructorComplaint> getAllInstructorComplaints() {
        return this.instructorComplaintService.getAllInstructorComplaints();
    }

    @GetMapping("/instructorComplaintRequests")
    public List<InstructorComplaint> getAllInstructorComplaintRequests() {
        return this.instructorComplaintService.getAllInstructorComplaints();
    }

    @GetMapping("/instructorComplaints/{id}")
    public ResponseEntity<InstructorComplaint> getInstructorComplaintById(@PathVariable(value = "id") int instructorComplaintId)
            throws ResourceNotFoundException {
        return instructorComplaintService.getInstructorComplaintById(instructorComplaintId);
    }




    @PostMapping("/instructorComplaints")
    public InstructorComplaint createInstructorComplaint(@RequestBody InstructorComplaint instructorComplaint) {
        return instructorComplaintService.createInstructorComplaint(instructorComplaint);
    }

    @PutMapping("/instructorComplaints/{id}")
    public ResponseEntity<InstructorComplaint> updateInstructorComplaint(@PathVariable(value = "id") int instructorComplaintId,
                                                               @RequestBody InstructorComplaint instructorComplaintDetails) throws ResourceNotFoundException {
        return instructorComplaintService.updateInstructorComplaint(instructorComplaintId, instructorComplaintDetails);
    }

    @DeleteMapping("/instructorComplaints/{id}")
    public Map<String, Boolean> deleteInstructorComplaint(@PathVariable(value = "id") int instructorComplaintId)
            throws ResourceNotFoundException {
        return instructorComplaintService.deleteInstructorComplaint(instructorComplaintId);
    }
}
