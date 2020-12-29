package com.taxfilingappicationsprint2.controller;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.taxfilingappicationsprint2.entity.Admin;
import com.taxfilingappicationsprint2.entity.Customer;
import com.taxfilingappicationsprint2.entity.Employer;
import com.taxfilingappicationsprint2.entity.Representative;
import com.taxfilingappicationsprint2.service.TaxFilngService;

import io.swagger.annotations.ApiOperation;

@RestController
public class TaxFilingController {

	@Autowired
	private TaxFilngService tfs;
	
	
	
	@PostMapping("/registerCustomer/{organizationName}")
	@ApiOperation("****if you are not employee put organization name as null****")
	public String registercustomer(@RequestBody Customer c,@PathVariable("organizationName")String orgName) {	
		String str="Registration unsuccessful";
		int i=0;
		Admin a=tfs.findAdmin("admin@gmail.com");
		c.setAdmin_c(a);
		if(c.getIsEmployee()==true) {
			Employer e=tfs.findEmployerByOrg(orgName);
			c.setEmployer(e);
			i=tfs.registerCustomer(c);
		}
				
		i=tfs.registerCustomer(c);
		if(i>0) {
			str="Registration successful";
		}
		 
		return str;
		
	}
	@PostMapping("/registerEmployer")
	public String registerEmployer(@RequestBody Employer e) {
		String str="Registration unsuccessful";
		e.setAdmin_e(tfs.findAdmin("admin@gmail.com"));
		int i=tfs.registerEmployer(e);
		if(i>0) {
			str="Registration successful";
		}
		 
		return str;
	}
	@PostMapping("/registerRepresentative")
	public String registerRepresentative(@RequestBody Representative r) {
		String str="Registration unsuccessful";
		r.setAdmin_r(tfs.findAdmin("admin@gmail.com"));
		int i=tfs.registerRepresentative(r);
		if(i>0) {
			str="Registration successful";
		}
		 
		return str;
	}
	
	
	@GetMapping("/login/{id},{password},{choice}")
	@ApiOperation("****Choice= 1.Customer 2.Employer 3.Representative****")
	public String login(@PathVariable("id")String id,@PathVariable("password")String password,@PathVariable("choice") Integer choice){
		System.out.println("Login by username and password");
		Object obj=null;
		switch(choice) {
			case 1: obj=tfs.loginCustomer(Long.parseLong(id), password);
					break;
			case 2: obj=tfs.loginEmployer(Long.parseLong(id), password);
					break;
			case 3: obj=tfs.loginRepresentative(Long.parseLong(id), password);
					break;
			case 4: obj=tfs.loginAdmin(id, password);
					break;
		}
		if(obj!=null)
			return "login succesfull";
		else
			return "Id or password is incorrect";
	}
	
	
	@PutMapping("/editCustomer/{id},{editChoice},{newValue}")
	@ApiOperation("****1.Name  2.Email  3.Password  4.Pan Number  5.Contact Number  6. Bank Account Number  7.Marital Status  8.Address****")
	public String upadteCustomer(@PathVariable("id")Long id,@PathVariable("editChoice")Integer choice,
			@PathVariable("newValue")String newValue) {
		
		int i=0;
		String[] res=new String[2];
		Customer c=tfs.findCustomer(id);
		System.out.println(c);
		switch(choice) {	
			case 1: c.setName(newValue);
					i=tfs.updateCustomer(c);
					res[0]="Name";res[1]=c.getName();
					break;
			case 2:	c.setEmail(newValue);
					i=tfs.updateCustomer(c);
					res[0]="Email";res[1]=c.getEmail();
					break;	
			case 3:	c.setPassword(newValue);
					i=tfs.updateCustomer(c);
					res[0]="Password";res[1]=c.getPassword();
					break;	
			case 4:	c.setPan(newValue);
					i=tfs.updateCustomer(c);
					res[0]="Pan";res[1]=c.getPan();
					break;	
			case 5:	c.setContactNo(newValue);
					i=tfs.updateCustomer(c);
					res[0]="Contact Number";res[1]=c.getContactNo();
					break;	
			case 6:	c.setAccountNo(newValue);
					i=tfs.updateCustomer(c);
					res[0]="Bank Account Number";res[1]=c.getAccountNo();
					break;	
			case 7:	c.setMaritalStatus(newValue);
					i=tfs.updateCustomer(c);
					res[0]="Marital Status";res[1]=c.getMaritalStatus();
					break;	
			case 8:	c.setAddress(newValue);
					i=tfs.updateCustomer(c);
					res[0]="Address";res[1]=c.getAddress();
					break;	
						
		}
		
	
	return "Your field "+res[0]+" with updated value is "+res[1];
	}
	
	@PutMapping("/editEmployer/{id},{editChoice},{newValue}")
	@ApiOperation(value="1.Email  2.Password  3.Contact Number")
	public String upadteEmployer(@PathVariable("id")Long id,@PathVariable("editChoice")Integer choice,
			@PathVariable("newValue")String newValue) {
		
		int i=0;
		String res[]=new String[2];
		Employer e=tfs.findEmployer(id);
		System.out.println(e);
		switch(choice) {	
			case 1:	e.setEmail(newValue);
					i=tfs.updateEmployer(e);
					res[0]="Email";res[1]=e.getEmail();	
					break;	
			case 2:	e.setPassword(newValue);
					i=tfs.updateEmployer(e);
					res[0]="Password";res[1]=e.getPassword();
					break;	
			case 3:	e.setContactNo(newValue);
					i=tfs.updateEmployer(e);
					res[0]="Contact Number";res[1]=e.getContactNo();
					break;	
			}
	
	return "Your field "+res[0]+" with updated value is "+res[1];
	}
	
	@PutMapping("/editRepresentative/{id},{editChoice},{newValue}")
	@ApiOperation(value="1.Name  2.Email  3.Password  4.Contact Number")
	public String upadteRepresentative(@PathVariable("id")Long id,@PathVariable("editChoice")Integer choice,
			@PathVariable("newValue")String newValue) {
		
		int i=0;
		String res[]=new String[2];
		Representative r=tfs.findRepresentative(id);
		System.out.println(r);
		switch(choice) {	
			case 1: r.setName(newValue);
					i=tfs.updateRepresentative(r);
					res[0]="Name"; res[1]=r.getName();
					break;
			case 2:	r.setEmail(newValue);
					i=tfs.updateRepresentative(r);
					res[0]="Email"; res[1]=r.getEmail();
					break;	
			case 3:	r.setPassword(newValue);
					i=tfs.updateRepresentative(r);
					res[0]="Password"; res[1]=r.getPassword();
					break;	
			case 4:	r.setContactNo(newValue);
					i=tfs.updateRepresentative(r);
					res[0]="Contact Number"; res[1]=r.getContactNo();
					break;	
			}
	
	return "Your field "+res[0]+" with updated value is "+res[1];
	}
	
	@PutMapping("/editAdmin/{id},{editChoice},{newValue}")
	@ApiOperation(value="1.password")
	public String upadteAdmin(@PathVariable("id")String id,@PathVariable("editChoice")Integer choice,
			@PathVariable("newValue")String newValue) {
		
		int i=0;
		String res[]=new String[2];
		Admin a=tfs.findAdmin(id);
		System.out.println(a);
		switch(choice) {	
			case 1: a.setPassword(newValue);
					i=tfs.updateAdmin(a);
					res[0]="Password";res[1]=a.getPassword();
					break;
		}
	return "Your field "+res[0]+"with updated value is "+res[1];
	}
	
	
	@PutMapping("/forgotPassword/{id},{userChoice},{questionChoice},{answer},{newPassword}")
	@ApiOperation("****userChoice****=1.Customer 2.Employer 3.Representative   "+"****QuestionChoice****= "
			+ "1.what is your nickname?, 2.what is place of birth?, 3.What is your fathers name?")
	public String forgotPassword(@PathVariable("id") String id, @PathVariable("userChoice") int choice,
			@PathVariable("questionChoice") int questionChoice,@PathVariable("answer") String answer,@PathVariable("newPassword") String newPass){
		
		List<String> questions=Arrays.asList("1.what is your nickname?","2.what is place of birth?","3.What is your fathers name?");
		
		String res="Sorry!! Question or answer is incorrect";
		switch(choice) {
		case 1: Customer c=tfs.findCustomer(Long.parseLong(id));
				if(c.getSecurityQuestion().equalsIgnoreCase(questions.get(questionChoice-1)) && c.getSecurityAnswer().equals(answer)) {
					c.setPassword(newPass);
					tfs.updateCustomer(c);
					res="Password resetted succesfully";
				}
				break;
		case 2: Employer e=tfs.findEmployer(Long.parseLong(id));
				if(e.getSecurityQuestion().equalsIgnoreCase(questions.get(questionChoice-1)) && e.getSecurityAnswer().equals(answer)) {
					e.setPassword(newPass);
					tfs.updateEmployer(e);
					res="Password resetted succesfully";
				}
				break;
		case 3: Representative r=tfs.findRepresentative(Long.parseLong(id));
				if(r.getSecurityQuestion().equalsIgnoreCase(questions.get(questionChoice-1)) && r.getSecurityAnswer().equals(answer)) {
					r.setPassword(newPass);
					tfs.updateRepresentative(r);
					res="Password resetted succesfully";
				}
				break;
		}
	
	return res;
}
	
}

