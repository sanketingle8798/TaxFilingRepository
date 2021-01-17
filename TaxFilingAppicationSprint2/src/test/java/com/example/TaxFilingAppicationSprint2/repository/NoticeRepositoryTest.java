package com.example.TaxFilingAppicationSprint2.repository;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.taxfilingappicationsprint2.TaxFilingAppicationSprint2Application;
import com.taxfilingappicationsprint2.entity.Notice;
import com.taxfilingappicationsprint2.repository.NoticeRepository;

import junit.framework.Assert;

@SuppressWarnings("deprecation")
@RunWith(SpringRunner.class)
@SpringBootTest(classes = TaxFilingAppicationSprint2Application.class)
public class NoticeRepositoryTest {
	
	@Autowired
	private NoticeRepository nr;

	@Test
	public void viewAdminNotice() {
		List<Notice> n1 = nr.viewadminnotice("sk@cg.com");
		Assert.assertEquals(n1.get(0).getNoticeBody(), "Approved");
	}
	
	@Test
	public void viewCustomerNotice() {
		List<Notice> n2 = nr.viewCustomerNotice((long) 3);
		assert n2.get(0).getNoticeBody().equals("Approved") : "Test Failed";
		Assert.assertEquals(n2.get(0).getNoticeBody(), "Approved");
	}
	
	@Test
	public void viewRepresentativeNotice() {
		List<Notice> n3 = nr.viewRepresentativeNotice((long) 1);
		assert n3.get(0).getNoticeBody().equals("Rejected") : "Test Failed";
	}

}