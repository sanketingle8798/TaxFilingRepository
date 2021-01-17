package com.taxfilingappicationsprint2.service;

import com.taxfilingappicationsprint2.entity.Admin;
import com.taxfilingappicationsprint2.entity.Customer;
import com.taxfilingappicationsprint2.entity.Employer;
import com.taxfilingappicationsprint2.entity.Representative;

public interface EditProfileService {
	Customer findCustomer(long id);

	
	Employer findEmployerByOrg(String newOrgName);

	Employer findEmployer(Long id);

	
	Representative findRepresentative(Long id);

	
	Admin findAdmin(String id);

	
	int removeCustomer(Long id);

	int removeEmployer(Long id);

	int removeRepresentative(Long id);

	Customer updateCustomer(Customer customer);
	
	Employer updateEmployer(Employer e);
	
	Representative updateRepresentative(Representative r);

	Admin updateAdmin(Admin a);
}
