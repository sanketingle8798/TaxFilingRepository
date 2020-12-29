package com.taxfilingappicationsprint2.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.taxfilingappicationsprint2.entity.Customer;

@Repository
public interface TaxFilingCustomerDao extends JpaRepository<Customer,Long>{

	@Query("SELECT c FROM Customer c where c.customerId=:customerId and c.password=:password")
	Customer loginCustomer(Long customerId,String password);

	@Query("SELECT c FROM Customer c where c.customerId=:id")
	Customer findCustomer(long id);
}
