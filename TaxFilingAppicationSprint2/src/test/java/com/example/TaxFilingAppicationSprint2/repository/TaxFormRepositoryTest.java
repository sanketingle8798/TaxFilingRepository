package com.example.TaxFilingAppicationSprint2.repository;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.taxfilingappicationsprint2.TaxFilingAppicationSprint2Application;
import com.taxfilingappicationsprint2.entity.TaxForm;
import com.taxfilingappicationsprint2.repository.TaxFormRepository;

import junit.framework.Assert;

@SuppressWarnings("deprecation")
@RunWith(SpringRunner.class)
@SpringBootTest(classes = TaxFilingAppicationSprint2Application.class)
public class TaxFormRepositoryTest {
	
	@Autowired
	private TaxFormRepository tr;

	@Test
	public void getTaxFormByPan() {
		TaxForm t1 = tr.getTaxFormByPan("asdf");
		double tt = t1.getTotalIncomeSalary();
		Assert.assertEquals(tt,1500000.0);
		
	}
}