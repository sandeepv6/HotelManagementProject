package com.otu.hotelmanagement.service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.otu.hotelmanagement.model.Booking;
import com.otu.hotelmanagement.model.Customer;
import com.otu.hotelmanagement.model.Room;
import com.otu.hotelmanagement.repository.BookingRepository;
import com.otu.hotelmanagement.repository.RoomRepository;
import com.otu.hotelmanagement.repository.CustomerRepository;

@Service
public class BookingService {
    private final BookingRepository bookingRepository;
    private final RoomRepository roomRepository;
    private final CustomerRepository customerRepository;
    
    @Autowired
    public BookingService(BookingRepository bookingRepository, RoomRepository roomRepository, CustomerRepository customerRepository) {
        super();
        this.bookingRepository = bookingRepository;
        this.roomRepository = roomRepository;
        this.customerRepository = customerRepository;
    }
    
    // Method to get all bookings
    public List<Booking> getAllBookings(){
        return bookingRepository.findAll();
    }
    
    // Method to get all available bookings
    public List<Room> getAvailableBookings(){
        return roomRepository.findAll();
    }
    
    // Method to check if a date is before the current date
    private boolean isBeforeCurrent(LocalDate date) {
        return date.isBefore(LocalDate.now());
    }
    
    // Method to book a room
    public String bookRoom(Long customerId, Long roomId, LocalDate startDate, LocalDate endDate) {
        // Check if customer exists
        Optional<Customer> customerExisting = customerRepository.findById(customerId);
        if (customerExisting.isEmpty()) {
            return "errorCustomerNotFound";
        }
        // Check if start date is before current date
        if (isBeforeCurrent(startDate)) {
            return "errorBeforeCurrent";
        }
        // Check for conflicting bookings
        List<Booking> conflictingBookings = bookingRepository.findConflictingBookings(roomId, startDate, endDate);
        if (!conflictingBookings.isEmpty()) {
            return "errorRoomUnavailable";
        }
        // Check if end date is after start date
        if (startDate.compareTo(endDate) > 0) {
            return "errorEndDate";
        }
        
        //Add room to list/database
        Booking booking = new Booking(customerId, roomId, startDate, endDate);
        bookingRepository.save(booking);
        return "success";
    }
    
    //Method to unbook a room
    public void unbookRoom(Long bookingId) {
        bookingRepository.deleteById(bookingId);
    }
}
