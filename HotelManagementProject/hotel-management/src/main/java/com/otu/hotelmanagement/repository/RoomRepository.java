package com.otu.hotelmanagement.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.otu.hotelmanagement.model.Room;

public interface RoomRepository extends JpaRepository<Room, Long>{
	
}