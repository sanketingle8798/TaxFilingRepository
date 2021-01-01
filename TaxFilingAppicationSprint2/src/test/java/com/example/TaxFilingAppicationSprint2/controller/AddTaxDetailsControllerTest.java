package com.example.TaxFilingAppicationSprint2.controller;

import java.util.Optional;

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
import com.taxfilingappicationsprint2.controller.AddTaxDetailsController;
import com.taxfilingappicationsprint2.entity.Customer;
import com.taxfilingappicationsprint2.entity.TaxForm;
import com.taxfilingappicationsprint2.repository.CustomerRepository;
import com.taxfilingappicationsprint2.repository.TaxFormRepository;
import com.taxfilingappicationsprint2.service.AddTaxDetailsServiceImpl;

import junit.framework.Assert;

@SuppressWarnings("deprecation")
@ContextConfiguration(classes = TaxFilingAppicationSprint2Application.class)
@ExtendWith(SpringExtension.class)
@WebMvcTest(value = {AddTaxDetailsController.class,AddTaxDetailsServiceImpl.class})
class AddTaxDetailsControllerTest {

	@Autowired
	private MockMvc mockMvc;
	 
	@MockBean
	private CustomerRepository cr;

	@MockBean
	private TaxFormRepository tr;
	
	@Test
	void testAddTaxDetailsForEmployee() throws Exception {
		String URI="/taxDetailsForEmployee";
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
		tf.setVerifiedStatus("pending");
		
		String jsonInput=this.convertToJson(tf);
		
		Mockito.when(tr.save(tf)).thenReturn(tf);
		 
		 //Mockito.when(addService.addTaxDetailsForEmployeeService(tf)).thenReturn(new Integer(1));
		 MvcResult mvcResult = this.mockMvc.perform(MockMvcRequestBuilders.put(URI).accept(MediaType.APPLICATION_JSON).content(jsonInput).contentType(MediaType.APPLICATION_JSON))
	                .andReturn();
	        MockHttpServletResponse mockHttpServletResponse = mvcResult.getResponse();
	        String jsonOutput = mockHttpServletResponse.getContentAsString();
	        Assert.assertEquals("Taxform details added successfully", jsonOutput);
			
		
	
	}

	@Test
	void testAddTaxDetailsByNewCustomer() throws Exception {
		String URI="/taxDetailsByNew";
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
		tf.setVerifiedStatus("pending");
		tf.setPan("abc12345");
		
		Customer cust=new Customer();
		cust.setCustomerId(1L);
		cust.setName("customer123");
		cust.setEmail("cust@gmail.com");
		cust.setPassword("password");
		cust.setSecurityQuestion("3.What is your fathers name?");
		cust.setSecurityAnswer("r");
		cust.setPan("abc12345");
		cust.setContactNo("987654");
		cust.setAccountNo("asdf123");
		//cust.setDateOfBirth(1998-07-08);
		cust.setMaritalStatus("single");
		cust.setAddress("Mumbai");
		cust.setIsEmployee(false);

	
	
		String jsonInput=this.convertToJson(tf);
		
		Mockito.when(cr.getCustByPan(tf.getPan())).thenReturn(cust);
		
		Mockito.when(cr.save(cust)).thenReturn(cust);
		
		MvcResult mvcResult = this.mockMvc.perform(MockMvcRequestBuilders.put(URI).accept(MediaType.APPLICATION_JSON).content(jsonInput).contentType(MediaType.APPLICATION_JSON))
	                .andReturn();
	        MockHttpServletResponse mockHttpServletResponse = mvcResult.getResponse();
	        String jsonOutput = mockHttpServletResponse.getContentAsString();
	        Assert.assertEquals("Taxform details added successfully(New Customer)", jsonOutput);
		
	}

	@Test
	void testAddTaxDetailsByCustomer() throws Exception {
		String URI="/taxDetailsByCustomer";
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
		tf.setVerifiedStatus("pending");
		

		Customer cust=new Customer();
		cust.setCustomerId(1L);
		cust.setName("customer123");
		cust.setEmail("cust@gmail.com");
		cust.setPassword("password");
		cust.setSecurityQuestion("3.What is your fathers name?");
		cust.setSecurityAnswer("r");
		cust.setPan("abc12345");
		cust.setContactNo("987654");
		cust.setAccountNo("asdf123");
		//cust.setDateOfBirth(1998-07-08);
		cust.setMaritalStatus("single");
		cust.setAddress("Mumbai");
		cust.setIsEmployee(false);
		
		String jsonInput=this.convertToJson(tf);
		
		Mockito.when(tr.findById(1L)).thenReturn(Optional.of(tf));
		
		Mockito.when(tr.save(tf)).thenReturn(tf);
		
		Mockito.when(cr.getCustByPan(tf.getPan())).thenReturn(cust);
		
		Mockito.when(cr.save(cust)).thenReturn(cust);
		
		MvcResult mvcResult = this.mockMvc.perform(MockMvcRequestBuilders.put(URI).accept(MediaType.APPLICATION_JSON).content(jsonInput).contentType(MediaType.APPLICATION_JSON))
                .andReturn();
        MockHttpServletResponse mockHttpServletResponse = mvcResult.getResponse();
        String jsonOutput = mockHttpServletResponse.getContentAsString();
	    Assert.assertEquals("Taxform details added successfully", jsonOutput);
		
	}

	
	private String convertToJson(Object rep) throws JsonProcessingException {
		ObjectMapper objectMapper = new ObjectMapper();
        return objectMapper.writeValueAsString(rep);
	}
}
