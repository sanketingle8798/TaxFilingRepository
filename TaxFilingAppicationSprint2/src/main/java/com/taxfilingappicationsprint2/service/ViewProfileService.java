package com.taxfilingappicationsprint2.service;

import java.util.List;

import com.taxfilingappicationsprint2.entity.Admin;
import com.taxfilingappicationsprint2.entity.Customer;
import com.taxfilingappicationsprint2.entity.Employer;
import com.taxfilingappicationsprint2.entity.Representative;

public interface ViewProfileService {

	Customer viewCustomerProfile(Long customerId);

	Employer viewEmployerProfile(Long employerId);

	Representative viewRepresentativeProfile(Long representativeId);

	List<Customer> viewAllCustomers();

	List<Employer> viewAllEmployers();

	List<Representative> viewAllRepresentatives();

	Admin viewAdminProfile(String adminId);

	List<Customer> viewAllEmployeesByOrganization(Employer emp);

	

}
