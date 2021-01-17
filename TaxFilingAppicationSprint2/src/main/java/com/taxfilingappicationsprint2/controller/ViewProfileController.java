package com.taxfilingappicationsprint2.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.taxfilingappicationsprint2.entity.Customer;
import com.taxfilingappicationsprint2.entity.Employer;
import com.taxfilingappicationsprint2.entity.Representative;
import com.taxfilingappicationsprint2.service.ViewProfileService;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
public class ViewProfileController {

	Logger logger = LoggerFactory.getLogger(ViewProfileController.class);
	
	@Autowired
	private ViewProfileService viewProfileService;

	@GetMapping("/viewCustomerProfile/{customerId}")
	public Customer viewCustomerProfile(@PathVariable("customerId") Long customerId) {
		return viewProfileService.viewCustomerProfile(customerId);
	}

	@GetMapping("/viewEmployerProfile/{employerId}")
	public Employer viewEmployerProfile(@PathVariable("employerId") Long employerId) {
		return viewProfileService.viewEmployerProfile(employerId);
	}

	@GetMapping("/viewRepresentativeProfile/{representativeId}")
	public Representative viewRepresentativeProfile(@PathVariable("representativeId") Long representativeId) {
		return viewProfileService.viewRepresentativeProfile(representativeId);
	}
	
	@GetMapping("/viewAllCustomers")
	public List<Customer> viewAllCustomers() {
		return viewProfileService.viewAllCustomers();
	}

	@GetMapping("/viewAllEmployers")
	public List<Employer> viewAllEmployers() {
		return viewProfileService.viewAllEmployers();
	}
	
	@GetMapping("/viewAllRepresentatives")
	public List<Representative> viewAllRepresentatives() {
		return viewProfileService.viewAllRepresentatives();
	}
	
	
	
}
