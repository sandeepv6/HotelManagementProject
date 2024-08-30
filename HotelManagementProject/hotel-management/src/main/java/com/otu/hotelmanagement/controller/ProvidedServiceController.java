package com.otu.hotelmanagement.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.otu.hotelmanagement.model.ProvidedService;
import com.otu.hotelmanagement.service.ProvidedServiceService;


@Controller
@RequestMapping("/services")
public class ProvidedServiceController {
	private final ProvidedServiceService provService;
	
	@Autowired
	public ProvidedServiceController(ProvidedServiceService provService) {
		super();
		this.provService = provService;
	}
	
	@GetMapping
	public String showServicesPage(Model model) {
		List<ProvidedService> allServices = provService.getAllServices();
		model.addAttribute("services", allServices);
		return "services";
	}
	
	@PostMapping("/add")
	public String addService(@RequestParam String name, @RequestParam String description, @RequestParam float price) {
		ProvidedService service = new ProvidedService(name, description, price);
		
		provService.addService(service);
		return "redirect:/services";
	}
}