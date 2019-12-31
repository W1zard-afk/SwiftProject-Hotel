package com.swiftacad.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.swiftacad.entity.Room;

@Repository
public interface RoomRepository extends CrudRepository<Room, Long> {

}
