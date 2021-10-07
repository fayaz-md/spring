package com.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.bean.Customer;

@Repository
public class CustomerDao {
	@Autowired
	EntityManagerFactory emf;
	
	public List<Customer> getCustomerDetails()
	{
		EntityManager em=emf.createEntityManager();
		Query query=em.createQuery("select c from Customer c");
		List<Customer>list=  query.getResultList();
		return list;
		
	}

	public int storeCustomer(Customer cust)
	{
		try {
		EntityManager em=emf.createEntityManager();
		EntityTransaction tran=em.getTransaction();
		tran.begin();
			em.persist(cust);
		tran.commit();
		}catch(Exception e)
		{
			return 0;
		}
		return 1;
	}
	public int deleteCustomer(int cid)
	{
		try {
			EntityManager em=emf.createEntityManager();
			EntityTransaction et=em.getTransaction();
			Customer c=em.find(Customer.class, cid);
			if(c==null)
				return 0;
			et.begin();
			em.remove(c);
			et.commit();
		
		} catch (Exception e) {
			// TODO: handle exception
			return 0;
		}
		return 1;
	}
	public int updateCustomer(Customer cust)
	{
		try {
			EntityManager em=emf.createEntityManager();
			EntityTransaction et=em.getTransaction();
			Customer c=em.find(Customer.class,cust.getCid());
			if(c==null)
				return 0;
			et.begin();
				c.setAge(cust.getAge());
				em.merge(c);
			et.commit();
			
		} catch (Exception e) {
			// TODO: handle exception
			return 0;
		}
		return 1;
	}
	public Customer getCustomerById(int id)
	{			
			EntityManager em=emf.createEntityManager();
			Customer c=em.find(Customer.class, id);
			return c;
		
	}
}
