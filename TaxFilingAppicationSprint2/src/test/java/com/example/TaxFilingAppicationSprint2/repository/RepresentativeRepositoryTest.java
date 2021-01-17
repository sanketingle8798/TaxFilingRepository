package com.example.TaxFilingAppicationSprint2.repository;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.taxfilingappicationsprint2.TaxFilingAppicationSprint2Application;
import com.taxfilingappicationsprint2.entity.Representative;
import com.taxfilingappicationsprint2.repository.RepresentativeRepository;

import junit.framework.Assert;

@SuppressWarnings("deprecation")
@RunWith(SpringRunner.class)
@SpringBootTest(classes = TaxFilingAppicationSprint2Application.class)
public class RepresentativeRepositoryTest {
	
	@Autowired
	private RepresentativeRepository rr;

	@Test
	public void loginRepresentative() {
		Representative r = rr.loginRepresentative(1, "password");
		assert r.getName().equals("rep100") : "Test Failed";
		Assert.assertEquals(r.getName(), "rep100");
	}

}