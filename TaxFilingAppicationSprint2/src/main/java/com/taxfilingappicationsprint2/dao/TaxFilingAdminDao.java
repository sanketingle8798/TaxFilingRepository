package com.taxfilingappicationsprint2.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.taxfilingappicationsprint2.entity.Admin;

@Repository
public interface TaxFilingAdminDao extends JpaRepository<Admin,String> {

	@Query("SELECT a FROM Admin a where a.email=:id and a.password=:password")
	public Admin loginAdmin(String id, String password);

/*	@Query("SELECT a FROM Admin a where a.email=:id")
	public Admin findAdmin(String id);
	
	*/
}
