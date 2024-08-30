package com.otu.hotelmanagement.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "services")
public class ProvidedService {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
	
    private String name;
    private String description;
    private float price;
    
    public ProvidedService() {
    	super();
    }

    public ProvidedService(String name, String description, float price){
        this.name = name;
        this.description = description;
        this.price = price;
    }

    public Long getId(){
        return this.id;
    }

    public String getName(){
        return this.name;
    }

    public void setName(String input){
        this.name = input;
    }

    public String getDescription(){
        return this.description;
    }

    public void setDescription(String input){
        this.description = input;
    }

    public float getPrice(){
        return this.price;
    }

    public void setPrice(float input){
        this.price = input;
    }

    public String toString(){
        return "Provided Service[id= " + id +", name= " + name + ", description= " + description + ", price= " + price + "]";
    }
}
