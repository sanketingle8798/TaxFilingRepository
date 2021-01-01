package com.taxfilingappicationsprint2.service;

import com.taxfilingappicationsprint2.entity.Admin;
import com.taxfilingappicationsprint2.entity.Customer;
import com.taxfilingappicationsprint2.entity.Employer;
import com.taxfilingappicationsprint2.entity.Representative;

public interface LoginService {
	Customer loginCustomer(Long customerId,String password);

	Employer loginEmployer(long id, String password);

	Representative loginRepresentative(long id, String password);

	Admin loginAdmin(String id, String password);
}
