package com.example.TaxFilingAppicationSprint2.Service;

import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import com.taxfilingappicationsprint2.TaxFilingAppicationSprint2Application;
import com.taxfilingappicationsprint2.entity.Customer;
import com.taxfilingappicationsprint2.entity.TaxForm;
import com.taxfilingappicationsprint2.repository.CustomerRepository;
import com.taxfilingappicationsprint2.repository.TaxFormRepository;
import com.taxfilingappicationsprint2.service.FileReturnServiceImpl;

import junit.framework.Assert;

@SuppressWarnings("deprecation")
@ContextConfiguration(classes = TaxFilingAppicationSprint2Application.class)
@ExtendWith(SpringExtension.class)
@SpringBootTest
class FileReturnServiceTest {

	@MockBean
	CustomerRepository customerRepository;
	@MockBean
	TaxFormRepository taxformRepository;
	@Autowired
	FileReturnServiceImpl filereturn;

	@Test
	void testFileReturn() {
		TaxForm tf = new TaxForm();
		tf.setTaxformId(1);
		tf.setVerifiedStatus("pending");
		Mockito.when(taxformRepository.fileReturn(tf)).thenReturn(1);
		int i = filereturn.fileReturn(tf);
		Assert.assertEquals(i, 1);

	}

	@Test
	void testGetTaxFromByPan() {
		TaxForm tf = new TaxForm();
		tf.setPan("4521");
		tf.setTaxformId(1);
		Mockito.when(taxformRepository.getTaxFormByPan(tf.getPan())).thenReturn(tf);
		TaxForm tf1 = filereturn.getTaxFromByPan("4521");

		Assert.assertEquals(tf.getTaxformId(), tf1.getTaxformId());

	}

	@Test
	void testGetCustomerById() {
		Customer c = new Customer();
		c.setCustomerId(3);
		c.setPan("4521");
		Mockito.when(customerRepository.findById(c.getCustomerId())).thenReturn(Optional.of(c));
		Customer c1 = filereturn.getCustomerById(3L);
		Assert.assertEquals(c.getPan(), (c1.getPan()));

	}

}