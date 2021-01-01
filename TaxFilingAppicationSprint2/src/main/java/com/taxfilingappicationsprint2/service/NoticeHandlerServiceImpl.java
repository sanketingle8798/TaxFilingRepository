package com.taxfilingappicationsprint2.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.taxfilingappicationsprint2.entity.Customer;
import com.taxfilingappicationsprint2.entity.Notice;
import com.taxfilingappicationsprint2.entity.TaxForm;
import com.taxfilingappicationsprint2.repository.CustomerRepository;
import com.taxfilingappicationsprint2.repository.NoticeRepository;
import com.taxfilingappicationsprint2.repository.TaxFormRepository;

@Service
public class NoticeHandlerServiceImpl implements NoticeHandlerService{
	@Autowired
	private NoticeRepository noticeRepo;
	
	@Autowired
	private TaxFormRepository taxformRepo;
	
	@Autowired
	private CustomerRepository customerRepo;
	@Override
	public List<Notice> viewadminnotice(String email) {
		
		return noticeRepo.viewadminnotice(email);
	}

	@Override
	public List<Notice> viewCustomerNotice(Long id) {
		
		List<Notice> notices=noticeRepo.viewCustomerNotice(id);
		return notices;
	}

	@Override
	public List<Notice> viewRepresentativeNotice(Long id) {
		
		List<Notice> notices=noticeRepo.viewRepresentativeNotice(id);
		return notices;
	}

	@Override
	public int addnotice(Notice n) {
		noticeRepo.save(n);
		return 1;
	}

	@Override
	public TaxForm getTaxformById(long taxformId) {
		TaxForm tf=taxformRepo.findById(taxformId).orElse(null);
		return tf;
	}

	@Override
	public int updateTaxForm(long taxformId, String status) {
		int i=taxformRepo.updateTaxForm(taxformId,status);
		return i;
	}

	@Override
	public Customer getCustomerById(long customerId) {
		Customer cust=customerRepo.findById(customerId).orElse(null);
		return cust;
	}
}
