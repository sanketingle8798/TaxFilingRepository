package com.taxfilingappicationsprint2.controller;

import java.util.ArrayList;
import java.util.List;

import javax.websocket.server.PathParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.taxfilingappicationsprint2.entity.Customer;
import com.taxfilingappicationsprint2.entity.Notice;
import com.taxfilingappicationsprint2.entity.TaxForm;
import com.taxfilingappicationsprint2.service.NoticeHandlerService;

@RestController
public class NoticeHandlerController {
	@Autowired
	private NoticeHandlerService ns;

	@GetMapping("/viewadminnotice/{email_n}")
	public List<Notice> viewadminnotice(@PathVariable("email_n") String email_n) {
		List<Notice> ll = ns.viewadminnotice(email_n);
		List<Notice> ll1 = new ArrayList<Notice>();
		for (Notice n : ll) {
			Notice n1 = new Notice();
			n1.setNoticeBody(n.getNoticeBody());
			n1.setNoticeId(n.getNoticeId());
			ll1.add(n1);
		}
		return ll1;
	}

	@GetMapping("/viewcustomernotice/{customer_id}")
	public List<Notice> viewCustomerNotice(@PathVariable("customer_id") Long id) {
		List<Notice> ll = ns.viewCustomerNotice(id);
		List<Notice> ll1 = new ArrayList<Notice>();
		
		for (Notice n : ll) {
			Notice n1 = new Notice();
			n1.setNoticeBody(n.getNoticeBody());
			n1.setNoticeId(n.getNoticeId());
			ll1.add(n1);
		}
		return ll1;
	}

	@GetMapping("/viewRepresentativeNotice/{representative_id}")
	public List<Notice> viewRepresentativeNotice(@PathVariable("representative_id") Long id) {
		List<Notice> ll = ns.viewRepresentativeNotice(id);
		List<Notice> ll1 = new ArrayList<Notice>();
		
		
		for (Notice n : ll) {
			Notice n1 = new Notice();
			n1.setNoticeBody(n.getNoticeBody());
			n1.setNoticeId(n.getNoticeId());
			ll1.add(n1);
		}
		return ll1;
	}

	@PostMapping("/addnotice")
	public String addnotice(@RequestBody Notice n) {
		String str = "Registration unsuccessful";
		
		int i = ns.addnotice(n);
		
		if (i > 0) {
			System.out.println("yess");
			str = "Notice  is sent";
		}
		Customer c=ns.getCustomerById(n.getCustomer().getCustomerId());
		System.out.println("Cust:"+c);
		TaxForm t = ns.getTaxformById(c.getTaxForm().getTaxformId());
		int i1 = 0;
		System.out.println("tax id "+t.getTaxformId());
		System.out.println("body"+ n.getNoticeBody());
		if (n.getNoticeBody().equals("Your Details are Incorrect .Your Application is Rejected."))
			i1 = ns.updateTaxForm(t.getTaxformId(),"rejected_r");
		else if (n.getNoticeBody().contains("Your Application is verified"))
			i1 = ns.updateTaxForm(t.getTaxformId(), "verified");
		else if (n.getNoticeBody().equals("Your Application is Rejected."))
			i1 = ns.updateTaxForm(t.getTaxformId(), "rejected_a");
		else if (n.getNoticeBody().equals("Your Application is Approved.")) {
				System.out.println("IN loop");
			i1 = ns.updateTaxForm(t.getTaxformId(), "approved");}
		System.out.println("i1"+i1);
		return str;
	}
}
