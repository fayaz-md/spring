package com.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.bean.Customer;
import com.service.CustomerService;

@RestController
public class CustomerController {
	@Autowired
	CustomerService customerService;
	@RequestMapping(value="allCustomers",produces=MediaType.APPLICATION_JSON_VALUE)
	public List<Customer> displayCustomerDetails()
	{
		return customerService.getCustomerDetails();
	}
	@RequestMapping(value="store",consumes=MediaType.APPLICATION_JSON_VALUE,method=RequestMethod.POST)
	public String storeCustomer(@RequestBody Customer cust)
	{
		
		return customerService.storeCustomerDetails(cust);
	
	}
	@RequestMapping(value="delete/{cid}",method=RequestMethod.DELETE)
	public String deleteCustomer(@PathVariable("cid") int cid)
	{
		return customerService.deleteCustomer(cid);
	}
	@RequestMapping(value="update",method=RequestMethod.PUT,consumes=MediaType.APPLICATION_JSON_VALUE)
	public String updateCustomer(@RequestBody Customer cust)
	{
		return customerService.updateCustomer(cust);
	}
	@RequestMapping(value="find/{cid}",produces=MediaType.APPLICATION_JSON_VALUE)
	public Customer findCustomer(@PathVariable("cid") int cid)
	{	
		return customerService.findCustomer(cid);
		
	}
}
