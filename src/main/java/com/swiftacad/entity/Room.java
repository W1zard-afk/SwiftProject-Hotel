package com.swiftacad.entity;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Room {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;
	private Integer room_number;
	private Integer room_size;
	@OneToMany
	private List<Reservation> reservations;
	
	public List<Reservation> getReservationss() {
		return reservations;
	}
	public void setClients(List<Reservation> reservations) {
		this.reservations = reservations;
	}
	public Long getID() {
		return id;
	}
	public void setID(Long id) {
		this.id = id;
	}
	public Integer getRoom_number() {
		return room_number;
	}
	public void setRoom_number(Integer room_number) {
		this.room_number = room_number;
	}
	public Integer getRoom_size() {
		return room_size;
	}
	public void setRoom_size(Integer room_size) {
		this.room_size = room_size;
	}
}
