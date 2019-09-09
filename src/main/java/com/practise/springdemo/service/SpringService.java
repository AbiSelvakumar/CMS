package com.practise.springdemo.service;

import java.util.List;
import java.util.Optional;
import java.util.concurrent.CopyOnWriteArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.practise.springdemo.dao.CustomerDAO;
import com.practise.springdemo.exception.CustomerNotFoundException;
import com.practise.springdemo.model.SpringModel;

@Component
public class SpringService {

	@Autowired
	private CustomerDAO customerDAO;

	//private int customerIdCount=1;
	private List<SpringModel> customerList=new CopyOnWriteArrayList<>();

	public SpringModel addCustomer(SpringModel customer)
	{
		/*customer.setCustomerId(customerIdCount);
		customerList.add(customer);
		customerIdCount++;*/
		return customerDAO.save(customer);
		//return customer;
	}

	public List<SpringModel> getCustomers()
	{
		return customerDAO.findAll();
		//return customerList;
	}

	public SpringModel getCustomer(int customerid)
	{
		/*return customerList
				.stream()
				.filter(c -> c.getCustomerId() == customerid)
				.findFirst()
				.get();*/
		Optional<SpringModel> optionalCustomer=customerDAO.findById(customerid);
		if(!optionalCustomer.isPresent()){
			throw new CustomerNotFoundException("Customer record is unavailable!");
		}
		return customerDAO.findById(customerid).get();
	}

	public SpringModel updateCustomer(int customerid,SpringModel customer)
	{
		/*customerList.stream().forEach(c -> {
		if(c.getCustomerId() == customerid) {
			c.setCustomerFirstName(customer.getCustomerFirstName());
			c.setCustomerLastName(customer.getCustomerLastName());
			c.setCustomerEmail(customer.getCustomerEmail());
		}});

		return customerList
				.stream()
				.filter(c -> c.getCustomerId() == customerid)
				.findFirst()
				.get();*/
		customer.setCustomerId(customerid);
		return customerDAO.save(customer);
	}

	public void deleteCustomer(int customerid)
	{
		/*customerList.stream().forEach(c -> {if(c.getCustomerId()==customerid){
			customerList.remove(c);
		}});*/
		customerDAO.deleteById(customerid);
	}
}
