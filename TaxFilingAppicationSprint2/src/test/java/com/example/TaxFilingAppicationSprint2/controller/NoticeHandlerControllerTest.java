package com.example.TaxFilingAppicationSprint2.controller;

import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.taxfilingappicationsprint2.TaxFilingAppicationSprint2Application;
import com.taxfilingappicationsprint2.controller.NoticeHandlerController;
import com.taxfilingappicationsprint2.entity.Customer;
import com.taxfilingappicationsprint2.entity.Notice;
import com.taxfilingappicationsprint2.entity.TaxForm;
import com.taxfilingappicationsprint2.service.NoticeHandlerService;
import com.taxfilingappicationsprint2.service.NoticeHandlerServiceImpl;

import junit.framework.Assert;

@SuppressWarnings("deprecation")
@ContextConfiguration(classes = TaxFilingAppicationSprint2Application.class)
@ExtendWith(SpringExtension.class)
@WebMvcTest(value = {NoticeHandlerController.class,NoticeHandlerServiceImpl.class})
class NoticeHandlerControllerTest {
	
	@Autowired
	private MockMvc mockMvc; 
	
	@MockBean
	private NoticeHandlerService noticeService;

	@Test
	void testViewadminnotice() throws Exception {
	
		String URI="/viewadminnotice/{email_n}";
	
		List<Notice> ll = new ArrayList<Notice>();
		
		Notice n1 = new Notice();
		n1.setNoticeBody("rejected");
		n1.setNoticeId(1L);
		ll.add(n1);
	
		Mockito.when(noticeService.viewadminnotice("admin@gmail.com")).thenReturn(ll);
		
		
		String jsonInput=this.convertToJson(ll);

		MvcResult mvcResult = this.mockMvc.perform(MockMvcRequestBuilders.get(URI,"admin@gmail.com").accept(MediaType.APPLICATION_JSON)).andReturn();
		MockHttpServletResponse mockHttpServletResponse = mvcResult.getResponse();
	    String jsonOutput = mockHttpServletResponse.getContentAsString();
	    Assert.assertEquals(jsonInput,jsonOutput);
	
	
	}

	@Test
	void testViewCustomerNotice() throws Exception {
		
		String URI="/viewcustomernotice/{customer_id}";
		
		List<Notice> ll = new ArrayList<Notice>();
		
		Notice n1 = new Notice();
		n1.setNoticeBody("rejected");
		n1.setNoticeId(1L);
		ll.add(n1);
	
		Mockito.when(noticeService.viewCustomerNotice(1L)).thenReturn(ll);
		
		String jsonInput=this.convertToJson(ll);

		MvcResult mvcResult = this.mockMvc.perform(MockMvcRequestBuilders.get(URI,1L).accept(MediaType.APPLICATION_JSON)).andReturn();
		MockHttpServletResponse mockHttpServletResponse = mvcResult.getResponse();
	    String jsonOutput = mockHttpServletResponse.getContentAsString();
	    Assert.assertEquals(jsonInput,jsonOutput);
	
	}

	@Test
	void testViewRepresentativeNotice() throws Exception {
		String URI="/viewRepresentativeNotice/{representative_id}";
		
		List<Notice> ll = new ArrayList<Notice>();
		
		Notice n1 = new Notice();
		n1.setNoticeBody("rejected");
		n1.setNoticeId(1L);
		ll.add(n1);
	
		Mockito.when(noticeService.viewRepresentativeNotice(1L)).thenReturn(ll);
		
		String jsonInput=this.convertToJson(ll);

		MvcResult mvcResult = this.mockMvc.perform(MockMvcRequestBuilders.get(URI,1L).accept(MediaType.APPLICATION_JSON)).andReturn();
		MockHttpServletResponse mockHttpServletResponse = mvcResult.getResponse();
	    String jsonOutput = mockHttpServletResponse.getContentAsString();
	    Assert.assertEquals(jsonInput,jsonOutput);
		
	}

	@Test
	void testAddnotice() throws Exception {
		
		String URI="/addnotice";
		
		TaxForm tf=new TaxForm();
		tf.setTaxformId(1L);
		tf.setPan("asdf");
		tf.setTotalIncomeSalary(10000);
		tf.setHra(100);
		tf.setOtherIncome(200);
		tf.setInterestIncome(300);
		tf.setRentalIncome(400);
		tf.setPpf(500);
		tf.setMedicalInsurance(2000);
		tf.setEducaionLoan(0);
		tf.setHouseLoan(5000);
		tf.setNps(100);
		tf.setSavingsInterest(300);
		tf.setTds(350);
		tf.setPayableTax(50);
		tf.setExtraInfo("nothing");
		tf.setVerifiedStatus("approved");
		tf.setPan("abc123");
		
		Customer cust=new Customer();
		cust.setCustomerId(1L);
		cust.setName("customer123");
		cust.setEmail("cust@gmail.com");
		cust.setPassword("password");
		cust.setSecurityQuestion("3.What is your fathers name?");
		cust.setSecurityAnswer("r");
		cust.setPan("abc123");
		cust.setContactNo("987654");
		cust.setAccountNo("asdf123");
		//cust.setDateOfBirth(1998-07-08);
		cust.setMaritalStatus("single");
		cust.setAddress("Mumbai");
		cust.setIsEmployee(false);
		cust.setTaxForm(tf);
		
		

		Notice n1 = new Notice();
		n1.setNoticeBody("Your Application is Approved.");
		n1.setNoticeId(1L);
		n1.setCustomer(cust);
	
		String status="approved";
		Mockito.when(noticeService.getCustomerById(1L)).thenReturn(cust);
		Mockito.when(noticeService.getTaxformById(cust.getTaxForm().getTaxformId())).thenReturn(tf);
		Mockito.when(noticeService.addnotice(Mockito.any(Notice.class))).thenReturn(1);
		Mockito.when(noticeService.updateTaxForm(tf.getTaxformId(),status)).thenReturn(new Integer(1));
		
		String jsonInput=this.convertToJson(n1);
		
		MvcResult mvcResult = this.mockMvc.perform(MockMvcRequestBuilders.post(URI).accept(MediaType.APPLICATION_JSON).content(jsonInput).contentType(MediaType.APPLICATION_JSON))
	                .andReturn();
	    MockHttpServletResponse mockHttpServletResponse = mvcResult.getResponse();
	    String jsonOutput = mockHttpServletResponse.getContentAsString();
	        
	    Assert.assertEquals("Notice  is sent",jsonOutput);
	}

	
	private String convertToJson(Object rep) throws JsonProcessingException {
		ObjectMapper objectMapper = new ObjectMapper();
        return objectMapper.writeValueAsString(rep);
	}

}
