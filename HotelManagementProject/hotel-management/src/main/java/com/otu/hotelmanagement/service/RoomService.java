package com.otu.hotelmanagement.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.otu.hotelmanagement.model.Room;
import com.otu.hotelmanagement.repository.RoomRepository;

@Service
public class RoomService {
	RoomRepository roomRepo;
	
	@Autowired
	public RoomService(RoomRepository roomRepo) {
		super();
		this.roomRepo = roomRepo;
	}
	
	public Room addRoom(Room room) {
		return roomRepo.save(room);
	}
	
	public List<Room> getAllRooms(){
		return roomRepo.findAll();
	}
	
}