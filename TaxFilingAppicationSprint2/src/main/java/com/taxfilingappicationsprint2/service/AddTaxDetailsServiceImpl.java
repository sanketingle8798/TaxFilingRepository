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
    public Customer getCustomerById(long customerId) {
        return customerRepo.getCustById(customerId);
    }

	@Override
	public int addTaxDetailsForEmployeeService(TaxForm objTaxForm) {
		objTaxForm.setVerifiedStatus("none");
		taxformRepo.save(objTaxForm);
		return 1;
	}

	@Override
	@Transactional
	public int addTaxDetailsByNewCustomerService(TaxForm objTaxForm) {
		objTaxForm.setVerifiedStatus("pending");
		taxformRepo.save(objTaxForm);
		Customer c = customerRepo.getCustByPan(objTaxForm.getPan());
		c.setTaxForm(objTaxForm);
		customerRepo.save(c);
		return 1;
	}

	@Override
	public int addTaxDetailsByEmpCustomerService(TaxForm objTaxForm) {
		TaxForm t = taxformRepo.getTaxFormByPan(objTaxForm.getPan());
		t.setTotalIncomeSalary(objTaxForm.getTotalIncomeSalary());
		t.setOtherIncome(objTaxForm.getOtherIncome());
		t.setInterestIncome(objTaxForm.getInterestIncome());
		t.setRentalIncome(objTaxForm.getRentalIncome());
		t.setPpf(objTaxForm.getPpf());
		t.setMedicalInsurance(objTaxForm.getMedicalInsurance());
		t.setEducationLoan(objTaxForm.getEducationLoan());
		t.setNps(objTaxForm.getNps());
		t.setSavingsInterest(objTaxForm.getSavingsInterest());
		t.setVerifiedStatus("pending");
		t.setPayableTax(objTaxForm.getPayableTax());
		taxformRepo.save(t);
		Customer c1 = customerRepo.getCustByPan(t.getPan());
		c1.setTaxForm(t);
		customerRepo.save(c1);
		return 1;
	}
	@Override
	public Customer getCustomerByPan(String pan) {
		return customerRepo.getCustByPan(pan);
	}
}