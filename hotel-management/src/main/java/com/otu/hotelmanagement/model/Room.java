package com.otu.hotelmanagement.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "rooms")
public class Room {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private int roomNumber;
    private String type;
    private double price;
    
    public Room() {
    	super();
    }


    public Room(int roomNumber, String type, double price){
        this.roomNumber = roomNumber;
        this.type = type;
        this.price = price;
    }
    
    public Long getRoomId() {
    	return this.id;
    }
    
    public void setRoomId(Long id) {
    	this.id = id;
    }

    public int getRoomNumber(){
        return this.roomNumber;
    }

    public void setRoomNumber(int input){
        this.roomNumber = input;
    }

    public String getType(){
        return this.type;
    }

    public void setType(String input){
        this.type = input;
    }

    public double getPrice(){
        return this.price;
    }

    public void setPrice(float input){
        this.price = input;
    }

    public String toString(){
        return "Room[id= " + id + ", room number= " + roomNumber + ", type=" + type + "price= " + price + "]";
    }
}
