	package com.otu.hotelmanagement.model;
	
	import java.time.LocalDate;
	
	import jakarta.persistence.Entity;
	import jakarta.persistence.GeneratedValue;
	import jakarta.persistence.GenerationType;
	import jakarta.persistence.Id;
	
	
	@Entity
	public class Booking {
		@Id
		@GeneratedValue(strategy = GenerationType.IDENTITY)
	    private Long id;
		
		// Initializing booking Information
	    private Long customerId;
	    private Long roomId;
	    
	    // Initializing Date Information
	    private LocalDate startDate;
	    private LocalDate endDate;
	    
	    // Constructors
	    public Booking() {
	    	super();
	    }
	
	    public Booking(Long customerId, Long roomId, LocalDate startDate, LocalDate endDate){
	        this.customerId = customerId;
	        this.roomId = roomId;
	        this.startDate = startDate;
	        this.endDate = endDate;
	    }
	
	    // Getters and Setters
	    public Long getId() {
	    	return this.id;
	    }
	    
	    public Long getCustomerId(){
	        return this.customerId;
	    }
	
	    public void setCustomerId(Long customer){
	        this.customerId = customer;
	    }
	    
	    public Long getRoomId(){
	        return roomId;
	    }
	    
	    public void setRoomId(Long roomId){
	        this.roomId = roomId;
	    }
	
	    public LocalDate getStartDate(){
	        return this.startDate;
	    }
	
	    public void setStartDate(LocalDate input){
	        this.startDate = input;
	    }
	
	    public LocalDate getEndDate(){
	        return this.endDate;
	    }
	
	    public void setEndDate(LocalDate input){
	        this.endDate = input;
	    }
	
	    // toString function
	    public String toString(){
	        return "Booking[id= " + id + ", customer id= " + customerId + ", room Id= " + roomId + ", start date= " + startDate + ", end date= " + endDate + "]";
	    }
	}
