package com.otu.hotelmanagement.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import java.util.Random;

import com.otu.hotelmanagement.model.Room;
import com.otu.hotelmanagement.service.RoomService;

@Controller
@RequestMapping("/rooms")
public class RoomController {
	private final RoomService roomService;
	
	@Autowired
	public RoomController(RoomService roomService) {
		this.roomService = roomService;
		Random rand = new Random();
		int randRoomNum = rand.nextInt(8) + 1;
		for(int i = 1; i <= randRoomNum; i++) {
			int typeInt = rand.nextInt(2);
			String roomType = "";
			if (typeInt == 0) {
				roomType = "Basic";
			} else {
				roomType = "Premium";
			}
			addRoom(100 + i, roomType, 100 + rand.nextInt(100) + (typeInt * 150));
		}
	}
	
	@GetMapping
	public String showRooms(Model model) {
		model.addAttribute("rooms", roomService.getAllRooms());
		return "rooms";
	}
	
	
	@PostMapping("/add")
	public String addRoom(@RequestParam int roomNumber, @RequestParam String type, @RequestParam float price) {
		Room room = new Room(roomNumber, type, price);
		
		roomService.addRoom(room);
		return "redirect:/rooms";
	}
}