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
public class RegistrationServiceImpl implements RegistrationService {
	@Autowired
	CustomerRepository customerRepo;
	@Autowired
	EmployerRepository employerRepo;
	@Autowired
	RepresentativeRepository repRepo;
	@Autowired
	AdminRepository adminRepo;

	public int registerCustomer(Customer c) {
		//System.out.println("cname:" + c.getName());
		customerRepo.save(c);
		return 1;
	}

	public int registerEmployer(Employer e) {
		
		employerRepo.save(e);
		return 1;
	}

	public int registerRepresentative(Representative r) {
		repRepo.save(r);
		return 1;
	}

	public int registerAdmin(Admin a) {
		adminRepo.save(a);
		return 1;
	}

	@Override
	public Employer findEmployerByOrg(String newOrgName) {
		return employerRepo.findEmployer(newOrgName);
	}

	@Override
	public Admin findAdmin(String id) {
		return adminRepo.findById(id).orElse(null);
	}
}
