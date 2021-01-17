package com.taxfilingappicationsprint2.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.taxfilingappicationsprint2.entity.Notice;
import com.taxfilingappicationsprint2.service.NoticeHandlerService;

import io.swagger.annotations.ApiOperation;

@RestController
public class NoticeHandlerController {
	
	Logger logger = LoggerFactory.getLogger(NoticeHandlerController.class);
	
	@Autowired
	private NoticeHandlerService viewNoticeService;

	@GetMapping("/viewadminnotice/{email_n}")
	@ApiOperation("Enter the admin Id")
	public List<Notice> viewadminnotice(@PathVariable("email_n") String email_n) {
		return viewNoticeService.viewadminnotice(email_n);
	}

	@GetMapping("/viewcustomernotice/{customer_id}")
	@ApiOperation("Enter the customer Id")
	public List<Notice> viewCustomerNotice(@PathVariable("customer_id") Long id) {
		return viewNoticeService.viewCustomerNotice(id);
	}

	@GetMapping("/viewRepresentativeNotice/{representative_id}")
	@ApiOperation("Enter the representative Id")
	public List<Notice> viewRepresentativeNotice(@PathVariable("representative_id") Long id) {
		return viewNoticeService.viewRepresentativeNotice(id);
	}
}
