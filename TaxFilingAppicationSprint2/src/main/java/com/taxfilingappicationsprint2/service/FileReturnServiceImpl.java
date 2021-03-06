package com.taxfilingappicationsprint2.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.taxfilingappicationsprint2.Exception.EntityNotFoundException;
import com.taxfilingappicationsprint2.entity.Admin;
import com.taxfilingappicationsprint2.entity.Customer;
import com.taxfilingappicationsprint2.entity.Notice;
import com.taxfilingappicationsprint2.entity.Representative;
import com.taxfilingappicationsprint2.entity.TaxForm;
import com.taxfilingappicationsprint2.repository.AdminRepository;
import com.taxfilingappicationsprint2.repository.CustomerRepository;
import com.taxfilingappicationsprint2.repository.NoticeRepository;
import com.taxfilingappicationsprint2.repository.RepresentativeRepository;
import com.taxfilingappicationsprint2.repository.TaxFormRepository;

@Service
public class FileReturnServiceImpl implements FileReturnService {

	@Autowired
	private TaxFormRepository taxformRepo;

	@Autowired
	private CustomerRepository customerRepo;

	@Autowired
	private RepresentativeRepository representativeRepo;

	@Autowired
	private NoticeRepository noticeRepo;

	@Autowired
	private AdminRepository adminRepo;

	@Override
	public int fileReturn(TaxForm t) {
		return taxformRepo.fileReturn(t);
	}

	@Override
	public TaxForm getTaxFromByPan(String pan) {
		TaxForm t = taxformRepo.getTaxFormByPan(pan);
		if (t == null)
			throw new EntityNotFoundException("Wrong pan", "Taxform with pan: " + pan + " doesn't exists",
					"Recheck pan", "Check list of Taxforms", "Reach out to ithelpdesk@taxportal.com");
		return t;
	}

	@Override
	public Customer getCustomerById(Long id) {
		Customer c = customerRepo.findById(id).orElse(null);
		if (c == null)
			throw new EntityNotFoundException("Wrong id", "Customer with id: " + id + " doesn't exists", "Recheck id",
					"Check list of Customers", "Reach out to ithelpdesk@taxportal.com");
		return c;
	}

	@Override
	public List<TaxForm> getTaxFormsForRepresentative() {
		return taxformRepo.getTaxFormsForRepresentative();
	}

	@Override
	public Customer getCustomerByTaxFormId(Long taxformId) {
		Customer c = customerRepo.getCustomerByTaxFormId(taxformId);
		if (c == null)
			throw new EntityNotFoundException("Wrong taxform id",
					"Customer with taxformid: " + taxformId + " doesn't exists", "Recheck taxform id",
					"View Customer profile", "Reach out to ithelpdesk@taxportal.com");
		return c;
	}

	@Override
	public Representative getRepresentativeById(Long representativeID) {
		Representative r = representativeRepo.findById(representativeID).orElse(null);
		if (r == null)
			throw new EntityNotFoundException("Wrong id",
					"Representative with id: " + representativeID + " doesn't exists", "Recheck with id",
					"Check list of Representatives", "Reach out to ithelpdesk@taxportal.com");
		return r;
	}

	@Override
	public int addNotice(Notice n) {
		noticeRepo.save(n);
		return 1;
	}

	@Override
	public int updateTaxForm(long taxformId, String status) {
		return taxformRepo.updateTaxForm(taxformId, status);
	}

	@Override
	public Admin getAdmin() {
		return adminRepo.findById("admin").orElse(null);
	}

	@Override
	public List<TaxForm> getTaxFormsForAdmin() {
		return taxformRepo.getTaxFormsForAdmin();
	}
}
