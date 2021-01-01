package com.taxfilingappicationsprint2.service;

import java.util.List;

import com.taxfilingappicationsprint2.entity.Customer;
import com.taxfilingappicationsprint2.entity.Notice;
import com.taxfilingappicationsprint2.entity.TaxForm;

public interface NoticeHandlerService {
	public List<Notice> viewadminnotice(String email);

	public List<Notice> viewCustomerNotice(Long id);

	public List<Notice> viewRepresentativeNotice(Long id);

	public int addnotice(Notice n);

	public TaxForm getTaxformById(long taxformId);

	public int updateTaxForm(long taxformId, String status);

	public Customer getCustomerById(long customerId);
}
