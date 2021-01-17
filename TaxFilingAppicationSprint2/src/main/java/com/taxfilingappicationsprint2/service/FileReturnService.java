package com.taxfilingappicationsprint2.service;

import java.util.List;

import com.taxfilingappicationsprint2.entity.Admin;
import com.taxfilingappicationsprint2.entity.Customer;
import com.taxfilingappicationsprint2.entity.Notice;
import com.taxfilingappicationsprint2.entity.Representative;
import com.taxfilingappicationsprint2.entity.TaxForm;

public interface FileReturnService {

	public int fileReturn(TaxForm t);

	public TaxForm getTaxFromByPan(String pan);

	public Customer getCustomerById(Long id);

	List<TaxForm> getTaxFormsForRepresentative();

	public Customer getCustomerByTaxFormId(Long taxformId);

	public Representative getRepresentativeById(Long representativeID);

	public int addNotice(Notice n);

	public int updateTaxForm(long taxformId, String status);

	public Admin getAdmin();

	public List<TaxForm> getTaxFormsForAdmin();
}
