package com.taxfilingappicationsprint2.service;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.taxfilingappicationsprint2.entity.Customer;
import com.taxfilingappicationsprint2.entity.TaxForm;
import com.taxfilingappicationsprint2.repository.CustomerRepository;
import com.taxfilingappicationsprint2.repository.TaxFormRepository;

@Service
public class AddTaxDetailsServiceImpl implements AddTaxDetailsService {
	@Autowired
	TaxFormRepository taxformRepo;

	@Autowired
	CustomerRepository customerRepo;

	@Override
	public int addTaxDetailsForEmployeeService(TaxForm objTaxForm) {
		TaxForm i=taxformRepo.save(objTaxForm);	
		return 1;
	}

	@Override
	@Transactional
	public int addTaxDetailsByNewCustomerService(TaxForm objTaxForm) {
		taxformRepo.save(objTaxForm);
		Customer c = customerRepo.getCustByPan(objTaxForm.getPan());
		c.setTaxForm(objTaxForm);
		Customer cust=customerRepo.save(c);
		
		return 1;
	}

	@Override
	public int addTaxDetailsByCustomerService(TaxForm objTaxForm) {
		TaxForm t = taxformRepo.findById(objTaxForm.getTaxformId()).orElse(null);
		t.setTotalIncomeSalary(objTaxForm.getTotalIncomeSalary());
		t.setOtherIncome(objTaxForm.getOtherIncome());
		t.setInterestIncome(objTaxForm.getInterestIncome());
		t.setRentalIncome(objTaxForm.getRentalIncome());
		t.setPpf(objTaxForm.getPpf());
		t.setMedicalInsurance(objTaxForm.getMedicalInsurance());
		t.setEducaionLoan(objTaxForm.getEducaionLoan());
		t.setNps(objTaxForm.getNps());
		t.setSavingsInterest(objTaxForm.getSavingsInterest());
		t.setVerifiedStatus("Pending");
		t.setPayableTax(objTaxForm.getPayableTax());
		t.setTaxformId(objTaxForm.getTaxformId());
		TaxForm tf=taxformRepo.save(t);
		Customer c1 = customerRepo.getCustByPan(objTaxForm.getPan());
		c1.setTaxForm(objTaxForm);
		Customer cust=customerRepo.save(c1);
		return 1;
	}
}
