package com.taxfilingappicationsprint2.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.taxfilingappicationsprint2.entity.Customer;
import com.taxfilingappicationsprint2.entity.TaxForm;
import com.taxfilingappicationsprint2.repository.CustomerRepository;
import com.taxfilingappicationsprint2.repository.TaxFormRepository;

@Service
public class FileReturnServiceImpl implements FileReturnService {

	@Autowired
	private TaxFormRepository taxformRepo;

	@Autowired
	private CustomerRepository customerRepo;

	@Override
	public int fileReturn(TaxForm t) {
		int i=taxformRepo.fileReturn(t);
		return i;
	}

	@Override
	public TaxForm getTaxFromByPan(String pan) {
		TaxForm tf=taxformRepo.getTaxFormByPan(pan);
		return tf;
	}

	@Override
	public Customer getCustomerById(Long id) {
		Customer cust=customerRepo.findById(id).orElse(null);
		return cust;
	}
}
