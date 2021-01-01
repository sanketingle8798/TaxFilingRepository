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
public class EditProfileServiceImpl implements EditProfileService {

	@Autowired
	CustomerRepository customerRepo;
	@Autowired
	EmployerRepository employerRepo;
	@Autowired
	RepresentativeRepository repRepo;
	@Autowired
	AdminRepository adminRepo;

	@Override
	public Customer findCustomer(long id) {
		return customerRepo.findById(id).orElse(null);
	}

	@Override
	public int updateCustomer(Customer c) {
		customerRepo.save(c);
		return 1;
	}

	@Override
	public Employer findEmployerByOrg(String newOrgName) {
		return employerRepo.findEmployer(newOrgName);
	}

	@Override
	public Employer findEmployer(Long id) {
		return employerRepo.findById(id).orElse(null);
	}

	@Override
	public int updateEmployer(Employer e) {
		employerRepo.save(e);
		return 1;
	}

	@Override
	public Representative findRepresentative(Long id) {
		return repRepo.findById(id).orElse(null);
	}

	@Override
	public int updateRepresentative(Representative r) {
		repRepo.save(r);
		return 1;
	}

	@Override
	public Admin findAdmin(String id) {
		return adminRepo.findById(id).orElse(null);
	}

	@Override
	public int updateAdmin(Admin a) {
		adminRepo.save(a);
		return 1;
	}
	@Override
	public int removeCustomer(Long id) {
		customerRepo.deleteById(id);
		return 1;
	}

	@Override
	public int removeEmployer(Long id) {
		employerRepo.deleteById(id);
		return 1;
	}

	@Override
	public int removeRepresentative(Long id) {
		repRepo.deleteById(id);	
		return 1;
	}
}
