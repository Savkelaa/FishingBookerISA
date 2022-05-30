package com.isa.fishingbooker.service;

import com.isa.fishingbooker.exception.ResourceNotFoundException;
import com.isa.fishingbooker.model.InstructorReport;
import com.isa.fishingbooker.model.ReservationPoints;
import com.isa.fishingbooker.repository.InstructorRepository;
import com.isa.fishingbooker.repository.ReservationPointsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

@Service
public class ReservationPointsService {

    @Autowired
    private ReservationPointsRepository reservationPointsRepository;

    public ResponseEntity<ReservationPoints> updateReservationPoints(Integer reservationPointstId,
                                                                   @RequestBody ReservationPoints reservationPointsDetails) throws ResourceNotFoundException {
        ReservationPoints reservationPoints = reservationPointsRepository.findById(reservationPointstId)
                .orElseThrow(() -> new ResourceNotFoundException("InstructorReport not found for this id :: " + reservationPointstId));

        reservationPoints.setPoints(reservationPointsDetails.getPoints());
        reservationPoints.setOwnerPoints(reservationPointsDetails.getOwnerPoints());

        final ReservationPoints reservationPointsReport = reservationPointsRepository.save(reservationPoints);
        return ResponseEntity.ok(reservationPointsReport);
    }

    public ResponseEntity<ReservationPoints> getReservationPointsById(int reservationPointsId)
            throws ResourceNotFoundException {
        ReservationPoints reservationPointsReport = reservationPointsRepository.findById(reservationPointsId).orElseThrow(() -> new ResourceNotFoundException("InstructorReport not found for this id :: " + reservationPointsId));
        return ResponseEntity.ok().body(reservationPointsReport);
    }


}
