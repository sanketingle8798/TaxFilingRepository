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
public class TaxFilingServiceImpl implements TaxFilngService {

	
	@Autowired
	private CustomerRepository cust;
	
	@Autowired
	private EmployerRepository emp;
	
	@Autowired
	private RepresentativeRepository rep;
	
	@Autowired
	private AdminRepository admin;
	
	
	@Override
	public int registerCustomer(Customer c) {
		cust.save(c);
		return 1;
	}

	@Override
	public int registerEmployer(Employer e) {
		emp.save(e);
		return 1;
	}

	@Override
	public int registerRepresentative(Representative r) {
		rep.save(r);
		return 1;
	}
	
	@Override
	public Customer loginCustomer(Long customerId,String password) {
		return cust.loginCustomer(customerId,password);
	}

	@Override
	public Employer loginEmployer(long id, String password) {
		return emp.loginEmployer(id,password);
	}

	@Override
	public Representative loginRepresentative(long id, String password) {
		return rep.loginRepresentative(id,password);
	}

	@Override
	public Admin loginAdmin(String id, String password) {
		return admin.loginAdmin(id,password);
	}

	@Override
	public Customer findCustomer(long id) {
		return cust.findById(id).orElse(null);
		
	}

	@Override
	public int updateCustomer(Customer c) {
		 cust.save(c);
		 return 1;
	}

	@Override
	public Employer findEmployerByOrg(String newOrgName) {
		return emp.findEmployer(newOrgName);
	}

	@Override
	public Employer findEmployer(Long id) {
		return emp.findById(id).orElse(null);
		
	}

	@Override
	public int updateEmployer(Employer e) {
		emp.save(e);
		return 1;
	}

	@Override
	public Representative findRepresentative(Long id) {
		return rep.findById(id).orElse(null);
		
	}

	@Override
	public int updateRepresentative(Representative r) {
		rep.save(r);
		return 1;
	}

	@Override
	public Admin findAdmin(String id) {
		return admin.findById(id).orElse(null);
		
	}

	@Override
	public int updateAdmin(Admin a) {
		admin.save(a);
		return 1;
	}

	@Override
	public int removeCustomer(Long id) {
		cust.deleteById(id);
		return 1;
	}

	@Override
	public int removeEmployer(Long id) {
		emp.deleteById(id);
		return 1;
	}

	@Override
	public int removeRepresentative(Long id) {
		rep.deleteById(id);	
		return 1;
	}
}
