package com.example.TaxFilingAppicationSprint2.entity;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.taxfilingappicationsprint2.TaxFilingAppicationSprint2Application;
import com.taxfilingappicationsprint2.entity.Admin;
import com.taxfilingappicationsprint2.entity.Customer;
import com.taxfilingappicationsprint2.entity.Employer;
import com.taxfilingappicationsprint2.entity.Notice;
import com.taxfilingappicationsprint2.entity.Representative;
import com.taxfilingappicationsprint2.entity.TaxForm;
import com.taxfilingappicationsprint2.repository.AdminRepository;

@ContextConfiguration(classes = TaxFilingAppicationSprint2Application.class)
@ExtendWith(SpringExtension.class)
@SpringBootTest
class CustomerTest {
	@Autowired
	AdminRepository aa;
	Admin a;
	Customer c;
	Representative r;
	Notice n;
	TaxForm t;
	Employer e;

	@BeforeEach
	void setUp() throws Exception {
		c = new Customer();
		e = new Employer();
		a = new Admin();
		t = new TaxForm();
		n = new Notice();
	}

	@AfterEach
	void tearDown() throws Exception {
		c = null;
	}

	@Test
	final void testGetCustomerId() {
		c.setCustomerId(1L);
		assertEquals(1L, c.getCustomerId());
	}

	@Test
	final void testSetCustomerId() {
		c.setCustomerId(1L);
		assertEquals(1L, c.getCustomerId());
	}

	@Test
	final void testGetName() {
		c.setName("Kajal");
		assertEquals("Kajal", c.getName());
	}

	@Test
	final void testSetName() {
		c.setName("Kajal");
		assertEquals("Kajal", c.getName());
	}

	@Test
	final void testGetEmail() {
		c.setEmail("abc@gmail.com");
		assertEquals("abc@gmail.com", c.getEmail());
	}

	@Test
	final void testSetEmail() {
		c.setEmail("abc@gmail.com");
		assertEquals("abc@gmail.com", c.getEmail());
	}

	@Test
	final void testGetPassword() {
		c.setPassword("123");
		assertEquals("123", c.getPassword());
	}

	@Test
	final void testSetPassword() {
		c.setPassword("123");
		assertEquals("123", c.getPassword());
	}

	@Test
	final void testGetSecurityQuestion() {
		c.setSecurityQuestion("What is your name?");
		assertEquals("What is your name?", c.getSecurityQuestion());
	}

	@Test
	final void testSetSecurityQuestion() {
		c.setSecurityQuestion("What is your name?");
		assertEquals("What is your name?", c.getSecurityQuestion());
	}

	@Test
	final void testGetSecurityAnswer() {
		c.setSecurityAnswer("abc");
		assertEquals("abc", c.getSecurityAnswer());
	}

	@Test
	final void testSetSecurityAnswer() {
		c.setSecurityAnswer("abc");
		assertEquals("abc", c.getSecurityAnswer());
	}

	@Test
	final void testGetPan() {
		c.setPan("PAN123");
		assertEquals("PAN123", c.getPan());
	}

	@Test
	final void testSetPan() {
		c.setPan("PAN123");
		assertEquals("PAN123", c.getPan());
	}

	@Test
	final void testGetContactNo() {
		c.setContactNo("908765432");
		assertEquals("908765432", c.getContactNo());
	}

	@Test
	final void testSetContactNo() {

		c.setContactNo("908765432");
		assertEquals("908765432", c.getContactNo());
	}

	@Test
	final void testGetAccountNo() {
		c.setAccountNo("Acc123");
		assertEquals("Acc123", c.getAccountNo());
	}

	@Test
	final void testSetAccountNo() {
		c.setAccountNo("Acc123");
		assertEquals("Acc123", c.getAccountNo());
	}

	@Test
	final void testGetDateOfBirth() {

		c.setDateOfBirth(LocalDate.now());
		assertEquals(LocalDate.now(), c.getDateOfBirth());

	}

	@Test
	final void testSetDateOfBirth() {
		c.setDateOfBirth(LocalDate.now());
		assertEquals(LocalDate.now(), c.getDateOfBirth());

	}

	@Test
	final void testGetMaritalStatus() {
		c.setMaritalStatus("No");
		assertEquals("No", c.getMaritalStatus());

	}

	@Test
	final void testSetMaritalStatus() {
		c.setMaritalStatus("No");
		assertEquals("No", c.getMaritalStatus());
	}

	@Test
	final void testGetAddress() {
		c.setAddress("Pune");
		assertEquals("Pune", c.getAddress());
	}

	@Test
	final void testSetAddress() {
		c.setAddress("Pune");

		assertEquals("Pune", c.getAddress());

	}

	@Test
	final void testGetIsEmployee() {
		c.setIsEmployee(true);

		assertEquals(true, c.getIsEmployee());

	}

	@Test
	final void testSetIsEmployee() {

		c.setIsEmployee(true);
		assertEquals(true, c.getIsEmployee());
	}

	@Test
	final void testGetEmployer() {
		c.setEmployer(e);
		assertNotNull(c.getEmployer());
	}

	@Test
	final void testSetEmployer() {
		c.setEmployer(e);
		assertNotNull(c.getEmployer());
	}

	@Test
	final void testGetAdmin_c() {
		c.setAdmin_c(a);
		assertNotNull(c.getAdmin_c());

	}

	@Test
	final void testSetAdmin_c() {
		c.setAdmin_c(a);
		assertNotNull(c.getAdmin_c());
	}

	@Test
	final void testGetTaxForm() {
		c.setTaxForm(t);
		assertNotNull(c.getTaxForm());
	}

	@Test
	final void testSetTaxForm() {
		c.setTaxForm(t);
		assertNotNull(c.getTaxForm());
	}

	@Test
	final void testSetNotices() {
		List<Notice> ll = new ArrayList<Notice>();
		n.setNoticeId(1L);
		n.setNoticeBody("Your application is approved");
		n.setAdmin_n(a);
		n.setRepresentative_n(r);
		n.setCustomer(c);
		ll.add(n);
		c.setNotices(ll);
		ll = c.getNotices();
		assertNotNull(ll);
	}

	@Test
	final void testGetNotices() {

		List<Notice> ll = new ArrayList<Notice>();
		n.setNoticeId(1L);
		n.setNoticeBody("Your application is approved");
		n.setAdmin_n(a);
		n.setRepresentative_n(r);
		n.setCustomer(c);
		ll.add(n);
		c.setNotices(ll);
		ll = c.getNotices();
		assertNotNull(ll);
	}

}