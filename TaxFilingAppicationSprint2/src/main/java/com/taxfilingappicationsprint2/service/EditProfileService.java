package com.taxfilingappicationsprint2.service;

import com.taxfilingappicationsprint2.entity.Admin;
import com.taxfilingappicationsprint2.entity.Customer;
import com.taxfilingappicationsprint2.entity.Employer;
import com.taxfilingappicationsprint2.entity.Representative;

public interface EditProfileService {
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
