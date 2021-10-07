package com.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bean.Customer;
import com.dao.CustomerDao;

@Service
public class CustomerService {
	@Autowired
	CustomerDao customerDao;
	public List<Customer> getCustomerDetails(){
		return customerDao.getCustomerDetails();
	}
	public String storeCustomerDetails(Customer cust)
	{
		if(customerDao.storeCustomer(cust)>0)
			return "Customer record stored successfully";
		return "Customer record didn't store. Try Again !!!!!!!";
	}
	public String deleteCustomer(int cid)
	{
		if(customerDao.deleteCustomer(cid)>0)
			return "Customer record deleted successfully";
		return "Customer record didn't delete. Try Again !!!!!!";
	}
	public String updateCustomer(Customer cust)
	{
		if(customerDao.updateCustomer(cust)>0)
			return "Customer record update successfully";
		return "Customer record didn't update. Try Again !!!!!!";
	}
	public Customer findCustomer(int cid)
	{
		return customerDao.getCustomerById(cid);
	}
}
