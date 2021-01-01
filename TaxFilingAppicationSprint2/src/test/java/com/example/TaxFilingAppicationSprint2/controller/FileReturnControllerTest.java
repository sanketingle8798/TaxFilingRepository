package com.example.TaxFilingAppicationSprint2.controller;

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

import com.taxfilingappicationsprint2.TaxFilingAppicationSprint2Application;
import com.taxfilingappicationsprint2.controller.FileReturnController;
import com.taxfilingappicationsprint2.entity.Customer;
import com.taxfilingappicationsprint2.entity.TaxForm;
import com.taxfilingappicationsprint2.service.FileReturnService;
import com.taxfilingappicationsprint2.service.FileReturnServiceImpl;

import junit.framework.Assert;

@SuppressWarnings("deprecation")
@ContextConfiguration(classes = TaxFilingAppicationSprint2Application.class)
@ExtendWith(SpringExtension.class)
@WebMvcTest(value = {FileReturnController.class,FileReturnServiceImpl.class})
class FileReturnControllerTest {

	
	@Autowired
	private MockMvc mockMvc;
	
	@MockBean
	private FileReturnService fileService;
	
	@Test
	void testFileReturn() throws Exception {
		String URI="/fileReturn/{customerId}";
		
		
		TaxForm tf=new TaxForm();
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
		
		Mockito.when(fileService.getTaxFromByPan("abc123")).thenReturn(tf);
		Mockito.when(fileService.getCustomerById(1L)).thenReturn(cust);
		
		MvcResult mvcResult = this.mockMvc.perform(MockMvcRequestBuilders.post(URI,1L).accept(MediaType.APPLICATION_JSON)).andReturn();

	    MockHttpServletResponse mockHttpServletResponse = mvcResult.getResponse();
	    String jsonOutput = mockHttpServletResponse.getContentAsString();
	    Assert.assertEquals("Your file return is already approved.", jsonOutput);
	}
}