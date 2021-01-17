package com.example.TaxFilingAppicationSprint2.repository;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.taxfilingappicationsprint2.TaxFilingAppicationSprint2Application;
import com.taxfilingappicationsprint2.entity.Employer;
import com.taxfilingappicationsprint2.repository.EmployerRepository;

import junit.framework.Assert;

@SuppressWarnings("deprecation")
@RunWith(SpringRunner.class)
@SpringBootTest(classes = TaxFilingAppicationSprint2Application.class)
public class EmployerRepositoryTest {
	
	@Autowired
	private EmployerRepository er;

	@Test
	public void loginEmployer() {
		Employer e1 = er.loginEmployer(1, "qwe");
		Assert.assertEquals(e1.getOrganization(), "CG");
		
	}
	
	@Test
	public void findEmployer() {
		Employer e2 = er.findEmployer("CG");
		Assert.assertEquals(e2.getEmail(), "abc@gmail.com");
	}

}