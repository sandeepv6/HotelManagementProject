package com.otu.hotelmanagement.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Customer {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
	
	// Initializing customer Information
    private String name;
    private long phoneNumber;
    private String email;
    
    // Constructors
    public Customer() {
    	super();
    }

    public Customer(String name, long phoneNumber, String email){
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.email = email;
    }

    // Getters and Setters
    public Long getId() {
    	return this.id;
    }

    public String getName(){
        return name;
    }

    public void setName(String input){
        this.name = input;
    }

    public long getPhoneNumber(){
        return this.phoneNumber;
    }

    public String getEmail(){
        return this.email;
    }

    public void setEmail(String input){
        this.email = input;
    }

    // toString function
	@Override
	public String toString() {
		return "Customer [id=" + id + ", customerId=" + id + ", name=" + name + ", phoneNumber=" + phoneNumber
				+ ", email=" + email + "]";
	}

    
}
