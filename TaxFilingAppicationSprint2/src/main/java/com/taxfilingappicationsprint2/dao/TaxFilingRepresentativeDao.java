package com.taxfilingappicationsprint2.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.taxfilingappicationsprint2.entity.Representative;

@Repository
public interface TaxFilingRepresentativeDao extends JpaRepository<Representative,Long>{

	@Query("SELECT r FROM Representative r where r.representativeId=:id and r.password=:password")
	public Representative loginRepresentative(long id, String password);

	/*@Query("SELECT r FROM Representative r where r.representativeId=:id")
	public Representative findRepresentative(Long id);*/

}
