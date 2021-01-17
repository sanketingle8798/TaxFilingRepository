package com.example.TaxFilingAppicationSprint2.repository;

import org.junit.jupiter.api.Test;

import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.taxfilingappicationsprint2.TaxFilingAppicationSprint2Application;
import com.taxfilingappicationsprint2.entity.Customer;
import com.taxfilingappicationsprint2.repository.CustomerRepository;

import junit.framework.Assert;

@SuppressWarnings("deprecation")
@RunWith(SpringRunner.class)
@SpringBootTest(classes = TaxFilingAppicationSprint2Application.class)
public class CustomerRepositoryTest {

		@Autowired
		private CustomerRepository cr;

		@Test
		public void getCustByPanTest() {
			Customer c = cr.getCustByPan("VVVVV1234B");
			Assert.assertEquals("Vaibhavi", c.getName());
		}

		@Test
		public void loginCustomerTest() {
			Customer c = cr.loginCustomer((long) 1, "Pass@12345");
			Assert.assertEquals("sanket", c.getName());
		}
	}