package com.otu.hotelmanagement.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.otu.hotelmanagement.model.ProvidedService;

public interface ServiceRepository extends JpaRepository<ProvidedService, Long>{
	
}