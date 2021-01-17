package com.taxfilingappicationsprint2.service;

import com.taxfilingappicationsprint2.entity.Customer;
import com.taxfilingappicationsprint2.entity.TaxForm;

public interface AddTaxDetailsService {

	int addTaxDetailsForEmployeeService(TaxForm objTaxForm);

	int addTaxDetailsByNewCustomerService(TaxForm objTaxForm);

	int addTaxDetailsByEmpCustomerService(TaxForm objTaxForm);

	Customer getCustomerByPan(String pan);
}
