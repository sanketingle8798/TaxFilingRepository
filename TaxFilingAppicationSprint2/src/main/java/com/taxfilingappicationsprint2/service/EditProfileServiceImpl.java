package com.taxfilingappicationsprint2.service;

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
public class EditProfileServiceImpl implements EditProfileService {

	@Autowired
	CustomerRepository customerRepo;

	@Autowired
	EmployerRepository employerRepo;

	@Autowired
	RepresentativeRepository representativeRepo;

	@Autowired
	AdminRepository adminRepo;

	@Override
	public Customer findCustomer(long id) {
		Customer c = customerRepo.findById(id).orElse(null);
		if (c == null)
			throw new EntityNotFoundException("Wrong id", "Customer with id: " + id + " doesn't exists", "Recheck id",
					"Check list of Customers", "Reach out to ithelpdesk@taxportal.com");
		return c;
	}

	@Override
	public Employer findEmployerByOrg(String newOrgName) {
		Employer e = employerRepo.findEmployer(newOrgName);
		if (e == null) {
			throw new EntityNotFoundException("Wrong organization name",
					"Organization with name: " + newOrgName + " doesn't exists", "Recheck organization name",
					"Check list of Organizations", "Reach out to ithelpdesk@taxportal.com");
		}
		return e;
	}

	@Override
	public Employer findEmployer(Long id) {
		Employer e = employerRepo.findById(id).orElse(null);
		if (e == null)
			throw new EntityNotFoundException("Wrong id", "Employer with id: " + id + " doesn't exists", "Recheck id",
					"Check list of Employers", "Reach out to ithelpdesk@taxportal.com");
		return e;
	}

	@Override
	public Representative findRepresentative(Long id) {
		Representative r = representativeRepo.findById(id).orElse(null);
		if (r == null)
			throw new EntityNotFoundException("Wrong id", "Customer with id: " + id + " doesn't exists", "Recheck id",
					"Check list of Representaives", "Reach out to ithelpdesk@taxportal.com");
		return r;
	}

	@Override
	public Admin findAdmin(String id) {
		return adminRepo.findById(id).orElse(null);
	}

	@Override
	public int removeCustomer(Long id) {
		if (!customerRepo.existsById(id))
			throw new EntityNotFoundException("Wrong id", "Customer with id: " + id + " doesn't exists",
					"Recheck with id", "Check list of Customers", "Reach out to ithelpdesk@taxportal.com");
		customerRepo.deleteById(id);
		return 1;
	}

	@Override
	public int removeEmployer(Long id) {
		if (!employerRepo.existsById(id))
			throw new EntityNotFoundException("Wrong id", "Employer with id: " + id + " doesn't exists",
					"Recheck with id", "Check list of Employers", "Reach out to ithelpdesk@taxportal.com");
		employerRepo.deleteById(id);
		return 1;
	}

	@Override
	public int removeRepresentative(Long id) {
		if (!representativeRepo.existsById(id))
			throw new EntityNotFoundException("Wrong id", "Representative with id: " + id + " doesn't exists",
					"Recheck with id", "Check list of Representatives", "Reach out to ithelpdesk@taxportal.com");
		representativeRepo.deleteById(id);
		return 1;
	}

	@Override
	public Customer updateCustomer(Customer customer) {
		return customerRepo.save(customer);
	}

	@Override
	public Employer updateEmployer(Employer e) {
		return employerRepo.save(e);
	}

	@Override
	public Representative updateRepresentative(Representative r) {
		return representativeRepo.save(r);
	}

	@Override
	public Admin updateAdmin(Admin a) {
		return  adminRepo.save(a);
	}
}
