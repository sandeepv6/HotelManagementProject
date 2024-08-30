package com.otu.hotelmanagement.repository;


import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.otu.hotelmanagement.model.Booking;



public interface BookingRepository extends JpaRepository<Booking, Long>{

	
	@Query("select b from Booking b where b.startDate >= :currentDate")
	List<Booking> noBookingBeforeCurrent(@Param("currentDate") LocalDate currentDate);
	
	@Query("SELECT b FROM Booking b WHERE b.roomId = :roomId AND :startDate < b.endDate AND :endDate > b.startDate")
    List<Booking> findConflictingBookings(@Param("roomId") Long roomId, @Param("startDate") LocalDate startDate, @Param("endDate") LocalDate endDate);

}
