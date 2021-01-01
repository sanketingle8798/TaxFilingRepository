package com.taxfilingappicationsprint2.service;

import com.taxfilingappicationsprint2.entity.Customer;
import com.taxfilingappicationsprint2.entity.TaxForm;

public interface FileReturnService {

	public int fileReturn(TaxForm t);

	public TaxForm getTaxFromByPan(String pan);

	public Customer getCustomerById(Long id);
}
