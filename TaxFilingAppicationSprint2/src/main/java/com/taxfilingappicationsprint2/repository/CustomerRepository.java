package com.taxfilingappicationsprint2.repository;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.taxfilingappicationsprint2.entity.Customer;
import com.taxfilingappicationsprint2.entity.Employer;
import com.taxfilingappicationsprint2.entity.TaxForm;

@Transactional
@Repository
public interface CustomerRepository extends JpaRepository<Customer, Long> {

	@Query("SELECT c FROM Customer c where c.pan=:pan")
	Customer getCustByPan(String pan);

	@Query("update Customer c set c.taxForm=:tf  where c.customerId=:id")
	int updateCust(TaxForm tf, long id);

	@Query("SELECT c FROM Customer c where c.customerId=:customerId and c.password=:password")
	Customer loginCustomer(Long customerId, String password);
	
	@Query("SELECT c FROM Customer c where c.taxForm.taxformId=:taxformId")
	Customer getCustomerByTaxFormId(Long taxformId);

	@Query("SELECT c FROM Customer c where c.employer=:emp")
	List<Customer> viewAllEmployeesByOrganization(Employer emp);
	
	
	@Query("SELECT c FROM Customer c where c.customerId=:customerId")
    Customer getCustById(long customerId);
	}
