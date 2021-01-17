package com.example.TaxFilingAppicationSprint2.entity;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.taxfilingappicationsprint2.entity.Admin;
import com.taxfilingappicationsprint2.entity.Customer;
import com.taxfilingappicationsprint2.entity.Employer;
import com.taxfilingappicationsprint2.entity.Notice;
import com.taxfilingappicationsprint2.entity.Representative;
import com.taxfilingappicationsprint2.entity.TaxForm;
import com.taxfilingappicationsprint2.repository.AdminRepository;

class NoticeTest {
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
		n = new Notice();
		c = new Customer();
		r = new Representative();
		a = new Admin();
	}

	@AfterEach
	void tearDown() throws Exception {
		n = null;
	}

	@Test
	final void testGetNoticeId() {
		n.setNoticeId(1L);
		assertEquals(1L, n.getNoticeId());

	}

	@Test
	final void testSetNoticeId() {
		n.setNoticeId(1L);
		assertEquals(1L, n.getNoticeId());

	}

	@Test
	final void testGetNoticeBody() {
		n.setNoticeBody("Your Application is approved");
		assertEquals("Your Application is approved", n.getNoticeBody());
	}

	@Test
	final void testSetNoticeBody() {
		n.setNoticeBody("Your Application is approved");
		assertEquals("Your Application is approved", n.getNoticeBody());
	}

	@Test
	final void testGetCustomer() {
		n.setCustomer(c);

		assertNotNull(n.getCustomer());
	}

	@Test
	final void testSetCustomer() {
		n.setCustomer(c);
		assertNotNull(n.getCustomer());
	}

	@Test
	final void testGetRepresentative_n() {
		n.setRepresentative_n(r);
		assertNotNull(n.getRepresentative_n());
	}

	@Test
	final void testSetRepresentative_n() {
		n.setRepresentative_n(r);
		assertNotNull(n.getRepresentative_n());
	}

	@Test
	final void testGetAdmin_n() {
		n.setAdmin_n(a);
		assertNotNull(n.getAdmin_n());
	}

	@Test
	final void testSetAdmin_n() {
		n.setAdmin_n(a);
		assertNotNull(n.getAdmin_n());
	}

}