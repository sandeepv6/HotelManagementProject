package com.otu.hotelmanagement.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.otu.hotelmanagement.model.Booking;
import com.otu.hotelmanagement.model.Room;
import com.otu.hotelmanagement.service.BookingService;

import java.time.LocalDate;
import java.util.List;

@Controller
@RequestMapping({"/","/bookings"})
public class BookingController {
	
	private final BookingService bookingService;
	
	@Autowired
	public BookingController(BookingService bookingService) {
		super();
		this.bookingService = bookingService;
	}
	
	@GetMapping
	public String showBookingPage(Model model) {
		List<Room> availableBookings = bookingService.getAvailableBookings();
		List<Booking> allBookings = bookingService.getAllBookings();
		
		model.addAttribute("availableBookings", availableBookings);
		model.addAttribute("allBookings", allBookings);
		return "bookings";
	}
	
	@PostMapping("/bookings/book")
	public String bookRoom(@RequestParam Long customerId, @RequestParam Long roomId, @RequestParam String startDate, @RequestParam String endDate, Model model) {
		LocalDate start = LocalDate.parse(startDate);
		LocalDate end = LocalDate.parse(endDate);
		
		String result = bookingService.bookRoom(customerId, roomId, start, end);
		
		if (result.equals("errorBeforeCurrent")) {
			model.addAttribute("errorMessage", "Cannot book a room before Current Date. >:( ");
			return "error";
		}
		else if (result.equals("errorRoomUnavailable")) {
			model.addAttribute("errorMessage", "This room is not available for booking at this time.");
			return "error";
		}
		else if (result.equals("errorCustomerNotFound")) {
			model.addAttribute("errorMessage", "This customer Id does not exist.");
			return "error";
		}
		else if (result.equals("errorEndDate")) {
			model.addAttribute("errorMessage", "End Date cannot be before Start Date");
			return "error";
		}
		return "redirect:/bookings";
	}
	
	@PostMapping("/bookings/unbook/{id}")
	public String unbookRoom(@PathVariable Long id) {	
		bookingService.unbookRoom(id);
		return "redirect:/bookings";
	}
}


