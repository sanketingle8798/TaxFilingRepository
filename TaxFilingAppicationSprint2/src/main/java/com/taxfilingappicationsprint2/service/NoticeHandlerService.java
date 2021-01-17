package com.taxfilingappicationsprint2.service;

import java.util.List;

import com.taxfilingappicationsprint2.entity.Notice;

public interface NoticeHandlerService {

	public List<Notice> viewadminnotice(String email);

	public List<Notice> viewCustomerNotice(Long id);

	public List<Notice> viewRepresentativeNotice(Long id);
}
