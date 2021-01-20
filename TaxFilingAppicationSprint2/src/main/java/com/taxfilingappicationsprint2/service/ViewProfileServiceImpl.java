package com.taxfilingappicationsprint2.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.taxfilingappicationsprint2.Exception.EntityNotFoundException;
import com.taxfilingappicationsprint2.entity.Admin;
import com.taxfilingappicationsprint2.entity.Customer;
import com.taxfilingappicationsprint2.entity.Employer;
import com.taxfilingappicationsprint2.entity.Representative;
import com.taxfilingappicationsprint2.repository.AdminRepository;
import com.taxfilingappicationsprint2.repository.CustomerRepository;
import com.taxfilingappicationsprint2.repository.EmployerRepository;
import com.taxfilingappicationsprint2.repository.RepresentativeRepository;

@Service
public class ViewProfileServiceImpl implements ViewProfileService {

	@Autowired
	private CustomerRepository customerRepo;

	@Autowired
	private EmployerRepository employerRepo;

	@Autowired
	private RepresentativeRepository representativeRepo;

	@Autowired
	private AdminRepository adminRepo;

	@Override
	public Customer viewCustomerProfile(Long customerId) {
		Customer c = customerRepo.findById(customerId).orElse(null);
		if (c == null)
			throw new EntityNotFoundException("Wrong id", "Customer with id: " + customerId + " doesn't exists",
					"Recheck id", "Check list of Customers", "Reach out to ithelpdesk@taxportal.com");
		return c;
	}

	@Override
	public Employer viewEmployerProfile(Long employerId) {
		Employer e = employerRepo.findById(employerId).orElse(null);
		if (e == null)
			throw new EntityNotFoundException("Wrong id", "Employer with id: " + employerId + " doesn't exists",
					"Recheck id", "Check list of Employers", "Reach out to ithelpdesk@taxportal.com");
		return e;
	}

	@Override
	public Representative viewRepresentativeProfile(Long representativeId) {
		Representative r = representativeRepo.findById(representativeId).orElse(null);
		if (r == null)
			throw new EntityNotFoundException("Wrong id", "Representative with id: " + representativeId + " doesn't exists",
					"Recheck id", "Check list of Representaives", "Reach out to ithelpdesk@taxportal.com");
		return r;
	}
	
	@Override
	public Admin viewAdminProfile(String adminId) {
		Admin admin = adminRepo.findById(adminId).orElse(null);
		if (admin == null)
			throw new EntityNotFoundException("Wrong id", "Admin with id: " + adminId + " doesn't exists",
					"Recheck id", "Check list of Representaives", "Reach out to ithelpdesk@taxportal.com");
		return admin;
	}

	@Override
	public List<Customer> viewAllCustomers() {
			return customerRepo.findAll();
	}

	@Override
	public List<Employer> viewAllEmployers() {
		return employerRepo.findAll();
	}

	@Override
	public List<Representative> viewAllRepresentatives() {
		return representativeRepo.findAll();
	}

	
	@Override
	public List<Customer> viewAllEmployeesByOrganization(Employer emp) {
		
		return customerRepo.viewAllEmployeesByOrganization(emp);
	}

	
}
