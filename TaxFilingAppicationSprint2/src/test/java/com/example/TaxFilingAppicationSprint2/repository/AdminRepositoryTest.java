package com.example.TaxFilingAppicationSprint2.repository;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.taxfilingappicationsprint2.TaxFilingAppicationSprint2Application;
import com.taxfilingappicationsprint2.entity.Admin;
import com.taxfilingappicationsprint2.repository.AdminRepository;

import junit.framework.Assert;

@SuppressWarnings("deprecation")
@RunWith(SpringRunner.class)
@SpringBootTest(classes = TaxFilingAppicationSprint2Application.class)
class AdminRepositoryTest {
	
	@Autowired
	private AdminRepository ar;
	
	
	@Test
	 void getloginAdmin() {
		Admin a3 = ar.loginAdmin("admin@gmail.com", "password");
		Assert.assertEquals(a3.getEmail(), "admin@gmail.com");
	}
}