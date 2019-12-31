package com.swiftacad.repository;


import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.swiftacad.entity.Reservation;

@Repository
public interface ReservationRepository extends CrudRepository<Reservation, Long>{
}
