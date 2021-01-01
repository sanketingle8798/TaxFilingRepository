package com.taxfilingappicationsprint2.controller;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.taxfilingappicationsprint2.entity.TaxForm;
import com.taxfilingappicationsprint2.service.AddTaxDetailsService;


@RestController
public class AddTaxDetailsController {
	@Autowired
	private AddTaxDetailsService ats;

	
	@PutMapping("/taxDetailsForEmployee")
	public String addTaxDetailsForEmployee(@RequestBody TaxForm objTaxForm) {
		String str = "Taxform details not added";
		Integer i = ats.addTaxDetailsForEmployeeService(objTaxForm);
		
		if (i > 0) {
			str = "Taxform details added successfully";
		}
		return str;

	}

	
	@PutMapping("/taxDetailsByNew")
	public String addTaxDetailsByNewCustomer(@RequestBody TaxForm objTaxForm) {
		
		String str = "Taxform details not added";
		int i = ats.addTaxDetailsByNewCustomerService(objTaxForm);
		if (i > 0) {
			str = "Taxform details added successfully(New Customer)";
		}
		return str;
	}

	
	@PutMapping("/taxDetailsByCustomer")
	public String addTaxDetailsByCustomer(@RequestBody TaxForm objTaxForm) {
		String str = "Taxform details not added";
		int i = ats.addTaxDetailsByCustomerService(objTaxForm);
		if (i > 0) {
			str= "Taxform details added successfully";
		}
		return str;

	}
}
