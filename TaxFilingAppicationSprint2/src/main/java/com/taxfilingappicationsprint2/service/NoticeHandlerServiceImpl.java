package com.taxfilingappicationsprint2.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.taxfilingappicationsprint2.entity.Notice;
import com.taxfilingappicationsprint2.repository.NoticeRepository;

@Service
public class NoticeHandlerServiceImpl implements NoticeHandlerService{
	@Autowired
	private NoticeRepository noticeRepo;

	@Override
	public List<Notice> viewadminnotice(String email) {
		return noticeRepo.viewadminnotice(email);
	}

	@Override
	public List<Notice> viewCustomerNotice(Long id) {
		return noticeRepo.viewCustomerNotice(id);
	}

	@Override
	public List<Notice> viewRepresentativeNotice(Long id) {
		return noticeRepo.viewRepresentativeNotice(id);
	}
}
