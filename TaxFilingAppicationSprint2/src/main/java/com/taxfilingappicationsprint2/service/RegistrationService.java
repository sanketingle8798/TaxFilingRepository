package com.taxfilingappicationsprint2.service;

import com.taxfilingappicationsprint2.entity.Admin;
import com.taxfilingappicationsprint2.entity.Customer;
import com.taxfilingappicationsprint2.entity.Employer;
import com.taxfilingappicationsprint2.entity.Representative;

public interface RegistrationService {
	
	public int registerCustomer(Customer c);

	public int registerEmployer(Employer e);

	public int registerRepresentative(Representative r);

	Admin findAdmin(String id);

	Employer findEmployerByOrg(String newOrgName);
}
