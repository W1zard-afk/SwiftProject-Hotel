package com.swiftacad.web;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.swiftacad.entity.Reservation;
import com.swiftacad.repository.ReservationRepository;

@RestController
public class ReservationController {
	@Autowired
	private ReservationRepository reservationRepository;
	
	@RequestMapping(value = "/createOrUpdateReservation", method = RequestMethod.POST)
	public ResponseEntity<Reservation> createOrUpdateReservation(@RequestBody Reservation reservation) {
		reservationRepository.save(reservation);
		return new ResponseEntity<>(HttpStatus.CREATED);
		}
	@RequestMapping(value = "/getReservationById/{id}", method = RequestMethod.GET)
	public ResponseEntity<Reservation> getReservationById(@PathVariable(value = "id") Long id) {
		Optional<Reservation> reservationOpt = reservationRepository.findById(id);
		if (reservationOpt.isPresent()) {
			return new ResponseEntity<>(reservationOpt.get(), HttpStatus.OK);
		}
		return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	}
	
}


