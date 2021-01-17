package com.taxfilingappicationsprint2.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.taxfilingappicationsprint2.entity.Admin;
import com.taxfilingappicationsprint2.entity.Customer;
import com.taxfilingappicationsprint2.entity.Employer;
import com.taxfilingappicationsprint2.entity.Representative;
import com.taxfilingappicationsprint2.repository.AdminRepository;
import com.taxfilingappicationsprint2.repository.CustomerRepository;
import com.taxfilingappicationsprint2.repository.EmployerRepository;
import com.taxfilingappicationsprint2.repository.RepresentativeRepository;

@Service
public class LoginServiceImpl implements LoginService{

	@Autowired
	CustomerRepository customerRepo;

	@Autowired
	EmployerRepository employerRepo;

	@Autowired
	RepresentativeRepository representativeRepo;

	@Autowired
	AdminRepository adminRepo;

	@Override
	public Customer loginCustomer(Long customerId, String password) {
		return customerRepo.loginCustomer(customerId, password);
	}

	@Override
	public Employer loginEmployer(long id, String password) {
		return employerRepo.loginEmployer(id, password);
	}

	@Override
	public Representative loginRepresentative(long id, String password) {
		return representativeRepo.loginRepresentative(id, password);
	}

	@Override
	public Admin loginAdmin(String id, String password) {
		return adminRepo.loginAdmin(id, password);
	}
}
