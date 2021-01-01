package com.taxfilingappicationsprint2.service;

import com.taxfilingappicationsprint2.entity.TaxForm;

public interface AddTaxDetailsService {
	int addTaxDetailsForEmployeeService(TaxForm objTaxForm);

	int addTaxDetailsByNewCustomerService(TaxForm objTaxForm);
	int addTaxDetailsByCustomerService(TaxForm objTaxForm);
}
