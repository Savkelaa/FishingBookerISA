package com.isa.fishingbooker.controller;

import com.isa.fishingbooker.exception.ResourceNotFoundException;
import com.isa.fishingbooker.model.InstructorReport;
import com.isa.fishingbooker.model.ReservationPoints;
import com.isa.fishingbooker.service.ClientService;
import com.isa.fishingbooker.service.ReservationPointsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin
@RestController
@RequestMapping("/api/v1")
public class ReservationPointsController {

    @Autowired
    private ReservationPointsService reservationPointsService;

    @PutMapping("/reservationPoints/{id}")
    public ResponseEntity<ReservationPoints> updateReservationPoints(@PathVariable(value = "id") int reservationPointsId,
                                                                   @RequestBody ReservationPoints reservationPointsDetails) throws ResourceNotFoundException {
       return reservationPointsService.updateReservationPoints(reservationPointsId,reservationPointsDetails);
    }

    @GetMapping("/reservationPoints/{id}")
    public ResponseEntity<ReservationPoints> getReservationPointsById(@PathVariable(value = "id") int reservationPointsId)
            throws ResourceNotFoundException {
        return reservationPointsService.getReservationPointsById(reservationPointsId);
    }

}
