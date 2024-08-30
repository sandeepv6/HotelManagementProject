package com.otu.hotelmanagement.service;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.otu.hotelmanagement.model.ProvidedService;
import com.otu.hotelmanagement.repository.ServiceRepository;

@Service
public class ProvidedServiceService {
	ServiceRepository serviceRepo;
	
	@Autowired
	public ProvidedServiceService(ServiceRepository serviceRepo) {
		super();
		this.serviceRepo = serviceRepo;
	}
	
	public ProvidedService addService(ProvidedService service) {
		return serviceRepo.save(service);
	}
	
	public List<ProvidedService> getAllServices(){
		return serviceRepo.findAll();
	}
	
	public List<ProvidedService> getServiceByIds(Long [] ids){
		return serviceRepo.findAllById(Arrays.asList(ids));
	}
	
	public ProvidedService getServiceById(Long id) {
		return serviceRepo.findById(id).orElse(null);
	}
	
}