package com.taxfilingappicationsprint2.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.taxfilingappicationsprint2.dao.TaxFilingAdminDao;
import com.taxfilingappicationsprint2.dao.TaxFilingCustomerDao;
import com.taxfilingappicationsprint2.dao.TaxFilingEmployerDao;
import com.taxfilingappicationsprint2.dao.TaxFilingRepresentativeDao;
import com.taxfilingappicationsprint2.entity.Admin;
import com.taxfilingappicationsprint2.entity.Customer;
import com.taxfilingappicationsprint2.entity.Employer;
import com.taxfilingappicationsprint2.entity.Representative;

@Service
public class TaxFilingServiceImpl implements TaxFilngService {

	
	@Autowired
	private TaxFilingCustomerDao cust;
	
	@Autowired
	private TaxFilingEmployerDao emp;
	
	@Autowired
	private TaxFilingRepresentativeDao rep;
	
	@Autowired
	private TaxFilingAdminDao admin;
	
	
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
		return cust.findCustomer(id);
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
		return emp.findEmployer(id);
	}

	@Override
	public int updateEmployer(Employer e) {
		emp.save(e);
		return 1;
	}

	@Override
	public Representative findRepresentative(Long id) {
		return rep.findRepresentative(id);
	}

	@Override
	public int updateRepresentative(Representative r) {
		rep.save(r);
		return 1;
	}

	@Override
	public Admin findAdmin(String id) {
		return admin.findAdmin(id);
	}

	@Override
	public int updateAdmin(Admin a) {
		admin.save(a);
		return 1;
	}
}
