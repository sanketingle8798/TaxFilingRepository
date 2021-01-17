package com.example.TaxFilingAppicationSprint2.Service;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import com.taxfilingappicationsprint2.TaxFilingAppicationSprint2Application;
import com.taxfilingappicationsprint2.entity.Admin;
import com.taxfilingappicationsprint2.entity.Customer;
import com.taxfilingappicationsprint2.entity.Employer;
import com.taxfilingappicationsprint2.entity.Representative;
import com.taxfilingappicationsprint2.repository.AdminRepository;
import com.taxfilingappicationsprint2.repository.CustomerRepository;
import com.taxfilingappicationsprint2.repository.EmployerRepository;
import com.taxfilingappicationsprint2.repository.RepresentativeRepository;
import com.taxfilingappicationsprint2.service.LoginServiceImpl;

import junit.framework.Assert;

@SuppressWarnings("deprecation")
@ContextConfiguration(classes = TaxFilingAppicationSprint2Application.class)
@ExtendWith(SpringExtension.class)
@SpringBootTest
class LoginServiceTest {
	@MockBean
	private CustomerRepository customerRepository;
	@MockBean
	private EmployerRepository employerRepository;
	@MockBean
	private RepresentativeRepository representativeRepository;
	@MockBean
	private AdminRepository adminrepository;
	@Autowired
	LoginServiceImpl loginservice;

	@Test
	void testLoginCustomer() {
		Customer c = new Customer();
		c.setCustomerId(3);
		c.setPassword("megha123");
		Mockito.when(customerRepository.loginCustomer(Mockito.anyLong(), Mockito.anyString())).thenReturn(c);
		Customer c1 = loginservice.loginCustomer(3L, "megha123");

		Assert.assertEquals(c.getCustomerId(), c1.getCustomerId());

	}

	@Test
	void testLoginEmployer() {
		Employer e = new Employer();
		e.setEmployerId(3);
		e.setPassword("sejal@123");
		Mockito.when(employerRepository.loginEmployer(Mockito.anyLong(), Mockito.anyString())).thenReturn(e);
		Employer e1 = loginservice.loginEmployer(3L, "sejal@123");

		Assert.assertEquals(e.getEmployerId(), e1.getEmployerId());

	}

	@Test
	void testLoginRepresentative() {
		Representative r = new Representative();
		r.setRepresentativeId(1);
		r.setPassword("tanvi123");
		Mockito.when(representativeRepository.loginRepresentative(Mockito.anyLong(), Mockito.anyString()))
				.thenReturn(r);
		Representative r1 = loginservice.loginRepresentative(1, "tanvi123");

		Assert.assertEquals(r.getPassword(), (r1.getPassword()));

	}

	@Test
	void testLoginAdmin() {
		Admin a = new Admin();
		a.setEmail("ruhi@gmail.com");
		a.setPassword("ruhi123");
		Mockito.when(adminrepository.loginAdmin(Mockito.anyString(), Mockito.anyString())).thenReturn(a);
		Admin a1 = loginservice.loginAdmin("ruhi@gmail.com", "ruhi123");

		Assert.assertEquals(a.getPassword(), (a1.getPassword()));

	}

}