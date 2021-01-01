package com.taxfilingappicationsprint2.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.taxfilingappicationsprint2.entity.Notice;

@Repository
public interface NoticeRepository extends JpaRepository<Notice, Long> {

	@Query("select n from Notice n where n.admin_n.email=:email")
	public List<Notice> viewadminnotice(String email);

	@Query("select n from Notice n INNER JOIN n.customer c where c.customerId=:id")
	public List<Notice> viewCustomerNotice(Long id);

	@Query("select n from Notice n INNER JOIN n.representative_n r where r.representativeId=:id")
	public List<Notice> viewRepresentativeNotice(Long id);
}
