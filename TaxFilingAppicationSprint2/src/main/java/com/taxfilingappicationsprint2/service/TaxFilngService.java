package com.taxfilingappicationsprint2.service;

import java.util.List;

import com.taxfilingappicationsprint2.entity.Admin;
import com.taxfilingappicationsprint2.entity.Customer;
import com.taxfilingappicationsprint2.entity.Employer;
import com.taxfilingappicationsprint2.entity.Representative;

public interface TaxFilngService {
	
	int registerCustomer(Customer c);

	int registerEmployer(Employer e);

	int registerRepresentative(Representative r);

	
	
	Customer loginCustomer(Long customerId,String password);

	Employer loginEmployer(long id, String password);

	Representative loginRepresentative(long id, String password);

	Admin loginAdmin(String id, String password);

	

	Customer findCustomer(long id);

	int updateCustomer(Customer c);

	
	Employer findEmployerByOrg(String newOrgName);

	Employer findEmployer(Long id);

	int updateEmployer(Employer e);

	
	Representative findRepresentative(Long id);

	int updateRepresentative(Representative r);

	
	Admin findAdmin(String id);

	int updateAdmin(Admin a);

	
	
	int removeCustomer(Long id);

	int removeEmployer(Long id);

	int removeRepresentative(Long id);

	
	
}
